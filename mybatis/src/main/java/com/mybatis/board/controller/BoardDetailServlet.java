package com.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.mybatis.board.dto.Board;
import com.mybatis.board.dto.Reply;
import com.mybatis.board.service.BoardService;
import com.mybatis.board.service.BoardServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detail.bo")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardService bService = new BoardServiceImpl();
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dno = Integer.parseInt(request.getParameter("bno"));
		
		int result = bService.increaseCount(dno);
		System.out.print(result);
		
		if(result > 0) {
			Board b = bService.selectBoard(dno);
			ArrayList<Reply> reply = bService.selectReplyList(dno);
			System.out.print(b.toString());
			for(Reply r : reply) {
				System.out.print(r.toString());
			}
		}
		
		
		
//		Board board = bService.selectBoard(dno);
		
		
//		request.setAttribute("board", board);
		/*
		 * request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp")
		 * .forward(request, response);
		 */
	}

}
