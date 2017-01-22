package com.example.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<head><title>Servlet Two</title></head>");
        pw.println("<body><h1>Test Sessions:</h1><br>");
        // Passing false means the method returns a pre-existing session,
        // or null if there was no session associated with this client:
        HttpSession session = request.getSession(false);
        
        // get attribute from session scope:
        String id = (String)session.getAttribute("ID");
        // if attribute was not set:
        if (id == null) id = "No attribute was set";
       
        pw.println("<hr>Session id from attribute get: " + id + "<hr>");
        // Now we can test for whether there was already a session the no-arg getSession() would 
        // NEVER NEVER return a null
        if (session == null) {
            pw.println("no session was available<br>");
            pw.println("making one \t");
            session = request.getSession(); // here we know 100% we making a new session because getSession() no-arg
        } else {
            pw.println("there was a session with id = " + session.getId());
            pw.println("<hr>");
        }
        pw.println("<br> encodeRedirectURL to Servlet1:<hr>");
        // Here we saying encodeURL(String URL) in this url where are server we adding
        // ;jsessionid=anyId explicitly but it will be hidden no matter what if even cookie are
        // disabled we still we get session id and then we can keep a session a live:
        pw.println("<a href=\"" + response.encodeRedirectURL("servlet1.do") + "\">click me </a>");
        pw.println("</body>");
        pw.println("</html>");
	}
}
