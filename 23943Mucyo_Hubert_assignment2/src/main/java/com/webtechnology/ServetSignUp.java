package com.webtechnology;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class ServetSignUp extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  String email = request.getParameter("email");
	      String password = request.getParameter("password");
	      
	      
	      if (email != null && password != null) {
		        HttpSession session = request.getSession();
		        session.setAttribute("email", email);
		        response.sendRedirect("home.html");
		    } else {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		        dispatcher.forward(request, response);
		    }
		
	}

}
