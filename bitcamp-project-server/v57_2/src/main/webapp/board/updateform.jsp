<%@page import="com.eomcs.lms.domain.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<jsp:include page="/header.jsp"></jsp:include>

<h1>게시물 변경</h1>
<form action='update' method='post'>
번호: <input name='no' readonly type='text' value='${board.no}'><br>
내용: <textarea name='title' rows='5' cols='60'><${board.title}</textarea>
등록일: ${board.date}<br>
조회수: ${board.viewCount}<br>
<button>변경</button>
</form>
<jsp:include page="/footer.jsp"/>
    