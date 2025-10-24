package com.mybatis.board.controller;

import java.io.IOException;

import com.mybatis.board.dto.Board;
import com.mybatis.board.service.BoardServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/boardInsert.bo")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Board b = new Board();
		b.setBoardwriter(request.getParameter("boardwriter"));
		b.setBoardcontent(request.getParameter("boardcontent"));
		b.setBoardtitle(request.getParameter("boardtitle"));
		int result = new BoardServiceImpl().insertBoard(b);
		request.getRequestDispatcher("WEB-INF/views/board/boardInsertView.jsp")
		.forward(request, response);
		
		response.getWriter().print(result);
	
	}

}
