package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

// DAO(Data Access Object)
@Repository("userDAO")
public class UserDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL 명령어들
	private final String USER_GET = "select * from users where id=? and password=?";
	private final String USER_INSERT ="insert into users(id, password, name, role) values (?, ?, ?, ?)";
	// CRUD기능의 메서드 구현
	// 회원 등록
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("===> JDBC로 getUser() 기능처리 ");
			conn = JDBCUtil.getConnetion();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
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
}
