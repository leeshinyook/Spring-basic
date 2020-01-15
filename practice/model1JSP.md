## Model 1. 아키텍쳐로 JSP게시판(CRUD) 만들기 

​	JSP로 게시판 CRUD기능 개발 중 책에서는 다루지않는 스스로 회원가입을 구현해본다. 

​	책 페이지로는 261페이지를 참고해주면 좋겠다.

- 아이디 중복체크와 같은 다루지 않았다.
- 최대한 부가적 코드작성없이 만들어진 VO, DAO를 활용하여 구현하고자 한다.

1. login.jsp 파일에 회원가입으로 향할 수 있는  <a>를 작성한다.

   ```jsp
   <tr>
   	<td colspan="1" align="center">
   		<a href="joinUser.jsp">회원가입</a>
   	</td>
   </tr>
   ```

2. joinUser.jsp 제작 (간단하게, 아이디와 비밀번호, 이름을 입력받는다.)

   ```jsp
   <%@ page contentType="text/html; charset=UTF-8" %>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <html>
   <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>회원가입</title>
   </head>
   <body>
   <center>
   <h1>회원가입</h1>
   <hr>
   <form action="joinUser_proc.jsp" method="post">
   <table border="1" cellpadding="0" cellspacing="0">
   	<tr>
   		<td bgcolor="orange">아이디</td>
   		<td><input type="text" name="id"/></td>
   	</tr>
   	<tr>
   		<td bgcolor="orange">비밀번호</td>
   		<td><input type="password" name="password"/></td>
   	</tr>
   	<tr>
   		<td bgcolor="orange">이름</td>
   		<td><input type="text" name="name"/></td>
   	</tr>
   	<tr>
   		<td colspan="2" align="center">
   			<input type="submit" value="가입하기"/>
   		</td>
   	</tr>
   </table>
   </form>
   <hr>
   </center>
   </body>
   </html>
   ```

3. joinUser_proc.jsp

   ```jsp
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
   ```

4. UserDAO insert메소드 추가.

   ```java
   private final String USER_INSERT ="insert into users(id, password, name, role) values (?, ?, ?, ?)";
   
   public void insertUser(UserVO vo) {
   		UserVO user = null;
   		try {
   			System.out.println("===> JDBC로 insertUser() 기능처리.");
   			conn = JDBCUtil.getConnetion();
   			stmt = conn.prepareStatement(USER_INSERT);
   			stmt.setString(1,  vo.getId());
   			stmt.setString(2,  vo.getPassword());
   			stmt.setString(3,  vo.getName());
   			stmt.setString(4,  vo.getRole());
   			stmt.executeUpdate();
   		} catch(Exception e) {
   			e.printStackTrace();
   		} finally {
   			JDBCUtil.close(stmt, conn);
   		}
   	}
   ```

결국은 VO(DTO)와 DAO를 통해 유저도 CRUD를 구성한다.

- VO, DTO(Data Transfer Object), 데이터 교환을 위한 자바 빈즈
  - VO는 DTO와 같은 개념이지만, read only 속성을 가진다.
  - 로직을 갖고 있지 않는 순수한 데이터 객체이며, 속성과 그 속성에 접근하기 위한 getter, setter메서드만을 가진 클래스
- DAO(Data Access Object)
  - 간단하게, Database의 data에 접근을 위한 객체
  - DB를 사용해 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 오브젝트
  - 즉, 사용자는 자신이 필요한 Interface를 DAO에게 던지고 DAO는 이 인터페이스를 구현한 객체를 사용자에게 편리하게 사용 할 수 있도록 반환해준다.

## DAO에 관해 더 자세히

- 웹 서버는 DB와 연결하기 위해 매번 커넥션 객체를 생성함
  - 매번 커넥션 객체 생성 -> 비효율적
- 위 방식을 해결하기 위해 '커넥션풀' 등장
  - 객체를 미리 만들어놓고 그것을 가져다 쓰는것.
  - 커넥션을 또 만드는 오버헤드를 효율적으로 하기 위해 DB에 접속하는 객체를 전용으로 하나 만듬
  - 그 후 , 모든 페이지에서 그 객체를 호출해서 사용
  - 이것이 DAO객체!