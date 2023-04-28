package com.ezen.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDao;
import com.ezen.dto.MemberDto;

public class DeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto mdto = (MemberDto)session.getAttribute("loginUser") ;

		MemberDao mdao = MemberDao.getInstance();
		int result=mdao.deleteMember(mdto.getUserid());
		
		//탈퇴를 성공하면 세션의 내용을 지우고 "회원탈퇴가 완료되었습니다" 라는 메세지를 가지고 로그인 폼으로 돌아가야함
		if(result==1) {
			session.removeAttribute("loginUser");
			request.setAttribute("message","회원탈퇴가 완료되었습니다");
		}
		
		RequestDispatcher dp = request.getRequestDispatcher("member/loginForm.jsp");
		dp.forward(request, response);

	}

}
