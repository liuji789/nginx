package com.liuji.nginx.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int port = request.getLocalPort();
		if(session.getAttribute("userId") == null){
			String userId =String.valueOf(new Random().nextInt(100));
			session.setAttribute("userId", userId);
			response.getWriter().append("<h1>hello,"+userId+" this is "+port+" port</h1>");
		}else{
			String userId = (String) session.getAttribute("userId");
			response.getWriter().append("<h1>Welcome back,"+userId+" this is "+port+" port</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
