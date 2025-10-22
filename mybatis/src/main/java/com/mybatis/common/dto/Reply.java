package com.mybatis.common.dto;

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
		super();
		this.replyno = reply_no;
		this.replycontent = reply_content;
		this.refbno = ref_bno;
		this.replywriter = reply_writer;
		this.createdate = create_date;
		this.status = status;
	}
	public int getReply_no() {
		return replyno;
	}
	public void setReply_no(int reply_no) {
		this.replyno = reply_no;
	}
	public String getReply_content() {
		return replycontent;
	}
	public void setReply_content(String reply_content) {
		this.replycontent = reply_content;
	}
	public int getRef_bno() {
		return refbno;
	}
	public void setRef_bno(int ref_bno) {
		this.refbno = ref_bno;
	}
	public String getReply_writer() {
		return replywriter;
	}
	public void setReply_writer(String reply_writer) {
		this.replywriter = reply_writer;
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
