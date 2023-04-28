package com.ezen.member.controller.action;

//<복습> 인터페이스 : 두 개 이상의 상속이 가능한 상속 전용 클래스

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;//추상메서드
	
}
