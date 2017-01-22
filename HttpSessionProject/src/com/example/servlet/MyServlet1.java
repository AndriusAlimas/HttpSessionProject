package com.example.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
public class MyServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException,IOException{
		 response.setContentType("text/html");
	     PrintWriter pw = response.getWriter();
	     pw.println("<html>");
	     pw.println("<head><title>Servlet One</title></head>");
	     pw.println("<body><h1>Test Session Attributes:</h1><br>");
	     // getSession() returns a session no matter what... but you can't tell if it's a new session unless 
	     // you ask the session. When you create session a lot things happen automatically like creating
	     // cookies, setting them to header:
	     HttpSession session = request.getSession(); // create session using request object
	     // get session unique id (important thing for saving information of cookies):
	     String id = session.getId();
	     // set attribute to a session scope:
	     session.setAttribute("ID", id);
	     // get last time accessed in this session:
	     Date date = new Date(session.getLastAccessedTime());
	     pw.println("<br><b>You was last time accessed: " + date + "</b><br>");
	     // returns true if the client has not yet responded with this session ID:
	        if (session.isNew()) {
	            pw.println("This is a new session " + id);
	        } else 
	        {
	        	// last session was not expired:
	            date = new Date(session.getCreationTime()); // to get time when was session created
	            pw.println("Welcome back " + id + " this session not new and was created " + date);
	        }
	        pw.println("<hr> Press link to go Server2 to encodeURL():<br>");
	        // Here we saying encodeURL(String URL) in this url where are server we adding
	        // ;jsessionid=anyId explicitly but it will be hidden no matter what if even cookie are
	        // disabled we still we get session id and then we can keep a session a live:
	        pw.println("<a href=\"" + response.encodeURL("servlet2.do") + "\">click me</a>");
	        pw.println("<br>The previous timeout was " + session.getMaxInactiveInterval() + " seconds");
	        pw.println("<hr>");
	        session.setMaxInactiveInterval(7200);
	        pw.println("</body>");
	        pw.println("</html>");
	}
}
