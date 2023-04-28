package com.ezen.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.member.controller.action.Action;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String command = request.getParameter("command");
		System.out.print(command);
		/*
		if(command.equals("loginForm")) {
			
			String url= "member/loginForm.jsp";
			RequestDispatcher dp = request.getRequestDispatcher(url);
			dp.forward(request, response);
			
		}else if(command.equals("logout")){
			
			HttpSession session = request.getSession();
			session.invalidate();
			RequestDispatcher dp = request.getRequestDispatcher("member/loginForm.jsp");
			dp.forward(request, response);
		
		// else if 커맨드로 쭉쭉 모든 기능 코드를 다 기재해도 작동은 함. 다만 후에 관리가 어렵고 코드를 찾기 어려워 단순한 방법으로는 코딩하지 않음
			
		}*/
		
		/*
		if(command.equals("loginForm")) {
			LoginFormAction lfa = new LoginFormAction();
			lfa.execute(request,response); 
			//request,response는 jsp파일에만 있으므로 전달인수로 전달을 해줌으로써 다른 클래스에서도 사용이 가능하게끔 함
		}else if(command.equals("logout")){
			LogOutAction loa = new LogOutAction();
			loa.execute(request,response);
		}
		*/
		
		Action ac = null;
		
		/*
		if(command.equals("loginForm"))  ac = new LoginFormAction();
			//부모인터페이스이기에 자식을 저장할 수 있게됨
			//request,response는 jsp파일에만 있으므로 전달인수로 전달을 해줌으로써 다른 클래스에서도 사용이 가능하게끔 함
		else if(command.equals("logout")) ac = new LogOutAction();
		*/
		
			ActionFactory af = ActionFactory.getInstance();
			ac=af.getAction(command);
		
		
			if(ac!=null)ac.execute(request,response); 
			else System.out.println("현재 command : "+command+" - command 값을 확인 하세요");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
