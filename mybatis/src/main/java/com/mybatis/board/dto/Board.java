package com.mybatis.board.dto;

import java.util.Date;

public class Board {
	private int boardno;
	private String boardtitle;
	private String boardcontent;
	private String boardwriter;
	private int count;
	private Date createdate;
	private String status;
    
    
	public Board() {
	}
	public Board(int board_no, String board_title, String board_content, String board_writer, int count,
			Date create_date, String status) {
		super();
		this.boardno = board_no;
		this.boardtitle = board_title;
		this.boardcontent = board_content;
		this.boardwriter = board_writer;
		this.count = count;
		this.createdate = create_date;
		this.status = status;
	}
	public int getBoard_no() {
		return boardno;
	}
	public void setBoard_no(int board_no) {
		this.boardno = board_no;
	}
	public String getBoard_title() {
		return boardtitle;
	}
	public void setBoard_title(String board_title) {
		this.boardtitle = board_title;
	}
	public String getBoard_content() {
		return boardcontent;
	}
	public void setBoard_content(String board_content) {
		this.boardcontent = board_content;
	}
	public String getBoard_writer() {
		return boardwriter;
	}
	public void setBoard_writer(String board_writer) {
		this.boardwriter = board_writer;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getCreate_date() {
		return createdate;
	}
	public void setCreate_date(Date create_date) {
		this.createdate = create_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
