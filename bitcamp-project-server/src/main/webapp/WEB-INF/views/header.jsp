<%@page import="com.eomcs.lms.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class='navbar navbar-expand-lg navbar-light'>
<a class='navbar-brand' href='../../index.html'>Bitcamp</a>
<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>
  <span class='navbar-toggler-icon'></span>
</button>
<div class='collapse navbar-collapse' id='navbarNav'>
  <ul class='navbar-nav mr-auto'>
    <li class='nav-item'>
      <a class='nav-link' href='../board/list'>게시글</a>
    </li>
    <li class='nav-item'>
      <a class='nav-link' href='../lesson/list'>수업</a>
    </li>
    <li class='nav-item'>
      <a class='nav-link' href='../member/list'>회원</a>
    </li>
  </ul>
<%
Member loginUser = (Member) request.getSession().getAttribute("loginUser");
if (loginUser != null) {
%>
  <span class= 'navbar-text'><%=loginUser.getName()%></span>
  <a href='../auth/logout' class='btn btn-primary btn-sm'>로그아웃</a>
<%
} else {
%>
  <a href='../auth/form' class='btn btn-primary btn-sm'>로그인</a>
<%
}
%>
</div>
</nav>
