<%@ page import="com.springbook.biz.user.impl.UserDAO" %>
<%@ page import="com.springbook.biz.user.UserVO" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
// 1. 사용자 입력 정보 추출.
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String password = request.getParameter("password");
String name = request.getParameter("name");
// 2. DB 연동 처리.
UserVO vo = new UserVO();
vo.setId(id);
vo.setPassword(password);
vo.setName(name);
vo.setRole("user");


vo.setRole("User");

UserDAO userDAO = new UserDAO();
userDAO.insertUser(vo);


// 3. 화면 네비게이션.
response.sendRedirect("login.jsp");
%>