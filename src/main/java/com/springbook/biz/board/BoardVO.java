package com.springbook.biz.board;

import java.sql.Date;

// VO(Value Object)
// database board table에 포함된 칼럼과 같은 이름의 멤버변수를 private 접근제한자로 선언한다. 그리고
// private 멤버변수에 접근하는 Getter / Setter 메소드를 선언한다.
// DTO(Data transfer Object)

public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title =" + title + ", writer =" + writer + ", content =" + content + ""
				+ "regDate = " + regDate + ", cnt = " + cnt + "]";
	}
	
}
