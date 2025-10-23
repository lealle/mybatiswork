package com.mybatis.common.dto;

public class PageInfo {
	private int totalRecord;	//총 게시글의 수
	private int nowPage;		// 사용자가 요청한 페이지(현재페이지)
	private int numPerPage; 	// 한페이지 내에 보여줄 게시글의 갯수
	private int pagePerBlock;	// 페이징바에 보여줄 페이징바의 개수 [1][2]...
	
	// 위의 4개를 가지고 계산 
	private int totalPage; 		// 총 페이지 수
	private int startPage;		// 페이징바의 시작수
	private int endPage;		// 페이징바의 끝의수
	
	public int getTotalRecord() {
		return totalRecord;
	}


	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}


	public int getNowPage() {
		return nowPage;
	}


	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}


	public int getNumPerPage() {
		return numPerPage;
	}


	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}


	public int getPagePerBlock() {
		return pagePerBlock;
	}


	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public PageInfo() {
		super();
	}


	public PageInfo(int totalRecord, int nowPage, int numPerPage, int pagePerBlock, int totalPage, int startPage,
			int endPage) {
		super();
		this.totalRecord = totalRecord;
		this.nowPage = nowPage;
		this.numPerPage = numPerPage;
		this.pagePerBlock = pagePerBlock;
		this.totalPage = totalPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	
	
}
