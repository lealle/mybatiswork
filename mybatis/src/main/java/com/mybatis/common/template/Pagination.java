package com.mybatis.common.template;

import com.mybatis.common.dto.PageInfo;

public class Pagination {
	public static PageInfo getPageInfo(int totalRecord,int nowPage,int numPerPage,int pagePerBlock) {
		int totalPage, startPage, endPage;
		totalPage = (int)Math.ceil(totalRecord / (double)numPerPage); 
		startPage = ((nowPage-1) / pagePerBlock)*pagePerBlock + 1; 
		endPage = ((nowPage-1) / pagePerBlock + 1)*pagePerBlock ; 
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		return new PageInfo(totalRecord,nowPage,numPerPage,pagePerBlock, totalPage, startPage, endPage);
	}
}
