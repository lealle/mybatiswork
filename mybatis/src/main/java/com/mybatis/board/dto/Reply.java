package com.mybatis.board.dto;

import java.util.Date;

public class Reply {
	private int replyno;
	private String replycontent;
	private int refbno;
	private String replywriter;
	private Date createdate;
	private String status;
    
	
    
	public Reply() {
	}
	public Reply(int reply_no, String reply_content, int ref_bno, String reply_writer, Date create_date,
			String status) {
		this.replyno = reply_no;
		this.replycontent = reply_content;
		this.refbno = ref_bno;
		this.replywriter = reply_writer;
		this.createdate = create_date;
		this.status = status;
	}
	public int getReplyno() {
		return replyno;
	}
	public void setReplyno(int reply_no) {
		this.replyno = reply_no;
	}
	public String getReplycontent() {
		return replycontent;
	}
	public void setReplycontent(String reply_content) {
		this.replycontent = reply_content;
	}
	public int getRefbno() {
		return refbno;
	}
	public void setRefbno(int ref_bno) {
		this.refbno = ref_bno;
	}
	public String getReplywriter() {
		return replywriter;
	}
	public void setReplywriter(String reply_writer) {
		this.replywriter = reply_writer;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date create_date) {
		this.createdate = create_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Reply [replyno=" + replyno + ", replycontent=" + replycontent + ", refbno=" + refbno + ", replywriter="
				+ replywriter + ", createdate=" + createdate + ", status=" + status + "]";
	}

    


}
