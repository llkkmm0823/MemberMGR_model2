package com.ezen.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDao;
import com.ezen.dto.MemberDto;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = new MemberDto();
		
		String name = request.getParameter("name");
		mdto.setName(name);
		
		mdto.setUserid(request.getParameter("userid"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		int result= mdao.insertMember(mdto);
		if(result==1) request.setAttribute("message","회원가입이 완료되었습니다. 로그인하세요");
		else request.setAttribute("message","회원가입이 실패하였습니다. 관리자에 문의하세요");
		
		RequestDispatcher rd = request.getRequestDispatcher("member/loginForm.jsp");
		rd.forward(request, response);
	}

}
