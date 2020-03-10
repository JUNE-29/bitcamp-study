package com.eomcs.mybatis.ex04;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Board implements Serializable {
  private static final long serialVersionUID = 1L;

  int no;
  String title;
  String content;
  Date registeredDate;
  int viewCount;
  List<AttachFile> files;

  // 개발하는 동안 객체의 값을 확인할 수 있도록 toString()을 오버라이딩 한다.
  @Override
  public String toString() {
    return "Board [no=" + no + ", title=" + title + ", content=" + content + ", registeredDate="
        + registeredDate + ", viewCount=" + viewCount + "]";
  }

  // 셋터와 겟터 생성

  public int getNo() {
    return no;
  }

  public List<AttachFile> getFiles() {
    return files;
  }

  public void setFiles(List<AttachFile> files) {
    this.files = files;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

}
