package com.eomcs.lms.dao.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

// 프록시 객체는 항상 작업 객체와 동일한 인터페이스를 구현해야 한다.
// => 마치 자신이 작업 객체인양 보이기 위함이다.
//
public class BoardDaoProxy implements BoardDao {

  DaoProxyHelper daoProxyHelper;

  public BoardDaoProxy(DaoProxyHelper daoProxyHelper) {
    this.daoProxyHelper = daoProxyHelper;
  }

  @Override
  public int insert(Board board) throws Exception {
    // 호출 하는 시점에서 연결된다.
    class InsertWorker implements Worker {

      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        out.writeUTF("/board/add");
        out.writeObject(board);
        out.flush();

        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
          // 이유를 읽고 Exception으로 해서 클라이언트에게 던진다.
        }
        return 1; // 오토박싱 되어서 리턴한다. valueOf Integer
      }
    }

    InsertWorker worker = new InsertWorker();

    int resultState = (int) daoProxyHelper.request(worker);

    return resultState;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Board> findAll() throws Exception {
    Worker worker = new Worker() {
      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        out.writeUTF("/board/list"); // 서버에 요청!

        out.flush();

        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return in.readObject();
      }
    };
    Object result = daoProxyHelper.request(worker);
    return (List<Board>) result;
  }

  @Override
  public Board findByNo(int no) throws Exception {

    Object result = daoProxyHelper.request(new Worker() {
      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {

        out.writeUTF("/board/detail");
        out.writeInt(no);
        out.flush();

        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return in.readObject();
      }
    });
    return (Board) result;
  }

  @Override
  public int update(Board board) throws Exception {

    return (int) daoProxyHelper.request(new Worker() {
      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {

        out.writeUTF("/board/update");
        out.writeObject(board);
        out.flush();

        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return 1; // 한 개 업데이트 했다.
      }
    });
  }

  @Override
  public int delete(int no) throws Exception {

    return (int) daoProxyHelper.request((in, out) -> {

      out.writeUTF("/board/delete");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return 1;
    });
  }
}
