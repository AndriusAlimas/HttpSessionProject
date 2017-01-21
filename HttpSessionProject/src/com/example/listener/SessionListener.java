package com.example.listener;
import javax.servlet.http.*;

public class SessionListener implements HttpSessionListener {
	public void sessionCreated(HttpSessionEvent event){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	     System.out.println("!!!!!!!!!!!sessionCreated() method run!!!!!!!!!!!!!!!!!!!!!!");
	}
	public void sessionDestroyed(HttpSessionEvent event){
		 System.out.println("!!!!!!!!!!!sessionDestroyed() method run!!!!!!!!!!!!!!!!!!!!!!");
	}
}
