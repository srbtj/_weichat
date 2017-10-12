package com.srbtj.common;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InterfaceUrlInitServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		super.init();
		System.out.println("========== init exec");
		InterfaceUrlInit.init();
	}
	
}
