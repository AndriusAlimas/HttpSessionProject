package com.example.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyServlet3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException,IOException{
		// this servlet just for invalidating a session:
		HttpSession session = request.getSession();
        session.invalidate();
	}
}
