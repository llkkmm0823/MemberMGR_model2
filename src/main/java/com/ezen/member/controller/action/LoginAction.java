package com.ezen.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDao;
import com.ezen.dto.MemberDto;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String url = "member/loginForm.jsp";
		
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);

		if (mdto == null) {
			request.setAttribute("message", "존재하지 않는 아이디입니다.");
		} else if (mdto.getPwd() == null) {
			request.setAttribute("message", "DB 오류. 관리자에게 문의하세요");
		} else if (!mdto.getPwd().equals(pwd)) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다");
		} else if (mdto.getPwd().equals(pwd)) {
			url = "member.do?command=main";
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto);
		} else {
			request.setAttribute("message", "무슨 이유에서인지 로그인이 되지 않습니다. 관리자에게 문의하세요");
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}
}

