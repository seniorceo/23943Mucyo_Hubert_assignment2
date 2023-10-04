package com.hubert;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAuths extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if ("hubert@auca.com".equals(email) && "password".equals(password)) {
            res.sendRedirect("home.html");
        } else {
            res.sendRedirect("password.html");
        	
        }
    }
}
