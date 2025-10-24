package com.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.mybatis.board.dto.Board;
import com.mybatis.board.dto.Reply;
import com.mybatis.board.service.BoardService;
import com.mybatis.board.service.BoardServiceImpl;
import com.mybatis.common.dto.PageInfo;
import com.mybatis.common.template.Pagination;

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
		String loginUser = request.getParameter("userid");
		int dno = Integer.parseInt(request.getParameter("bno"));
		int nowPage = 1;

		if (request.getParameter("nowPage") != null) {
		    nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}

		if (request.getSession().getAttribute("viewedBoard_" + dno) == null) {
		    int result = bService.increaseCount(dno);

		    if (result > 0) {
		        request.getSession().setAttribute("viewedBoard_" + dno, true);
		    }
		}

		Board b = bService.selectBoard(dno);

		if (b != null) {
		    int replySize = bService.replyRecord(dno);
		    PageInfo rpi = Pagination.getPageInfo(replySize, nowPage, 5, 2);
		    ArrayList<Reply> reply = bService.selectReplyList(dno, rpi);

		    request.setAttribute("b", b);
		    request.setAttribute("rpi", rpi);
		    request.setAttribute("reply", reply);

		    request.getRequestDispatcher("WEB-INF/views/board/boardDetailView.jsp")
		           .forward(request, response);

		} else {
		    request.setAttribute("errorMsg", "존재하지 않는 게시글입니다.");
		    request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp")
		           .forward(request, response);
		}
		
		
		
		// pplx.ai/comet_with_pro
		// https://pplx.ai/free-comet-students-korea
		// PCS
		// AI 의 질문법 , 왜 그렇게 만들었는지 (장단점을 어느정도 파악하는지, 프로젝트에 대한 이해도가 있는지)
		// AI 사용 LMarena -leaderboard(어느것이 좋은지)
		// OOP, 확정성, 미래의 확장성을 염두에 둔 코드 구현 
		// 
		
		
		
	}

}
