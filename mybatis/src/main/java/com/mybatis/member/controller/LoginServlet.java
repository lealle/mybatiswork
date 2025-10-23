package com.mybatis.member.controller;

import java.io.IOException;

import com.mybatis.member.dto.Member;
import com.mybatis.member.service.MemberServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// loginservlet -> Impl ->memberrepository -> mapper 
		Member m = new Member();
		m.setUserId(request.getParameter("userId"));
		m.setUserPwd(request.getParameter("userPwd"));
		
		Member loginMem = new MemberServiceImpl().loginMember(m);
		if(loginMem == null) {
			request.setAttribute("errorMsg", "로그인 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp")
										.forward(request, response);
		}else {
			request.getSession().setAttribute("loginMem", loginMem);
			response.sendRedirect(request.getContextPath());
		}
		
		
		
	}
}
