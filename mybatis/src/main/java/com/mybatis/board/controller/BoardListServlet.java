package com.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.mybatis.board.dto.Board;
import com.mybatis.board.service.BoardServiceImpl;
import com.mybatis.common.dto.PageInfo;
import com.mybatis.common.template.Pagination;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int totalRecord = new BoardServiceImpl().totalRecord();	//총 게시글의 수
		int nowPage = Integer.parseInt( request.getParameter("nowPage"));		// 사용자가 요청한 페이지(현재페이지)
		
		PageInfo pi = Pagination.getPageInfo(totalRecord, nowPage, 5, 2);
		ArrayList<Board> list = new BoardServiceImpl().selectList(pi);
		
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp")
									.forward(request, response);
	
	}

}
