package com.ezen.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDao;

public class Editadmin implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String admin = request.getParameter("admin");
		
		//현재 등급을 보고 수정할 등급으로 변수값을 수정
		if(admin.equals("1"))admin="0";
		else admin = "1";
		
		//수정 메서드 이름은 editAdmin으로 하고 전달인수는 아이디와 수정할 등급 두 개만 전달
		MemberDao mdao = MemberDao.getInstance();
		mdao.editAdmin(userid,admin);
		
		//수정을 완료하면 main.jsp로 되돌아감
		RequestDispatcher dp = request.getRequestDispatcher("member.do?command=main");
		dp.forward(request, response);

	}

}
