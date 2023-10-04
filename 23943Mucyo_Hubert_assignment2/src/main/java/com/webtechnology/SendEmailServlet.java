package com.webtechnology;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendmail")
@MultipartConfig
public class SendEmailServlet extends HttpServlet {
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        PrintWriter out = response.getWriter();
	        
	        String email = (String) request.getSession().getAttribute("email");

	        if (email != null && !email.isEmpty()) {
	            if (sendGmail(email)) {
	                out.println("Upload successful! Confirmation email sent to " + email);
	            } else {
	                out.println("Upload successful, but Sorry, failed to send confirmation email to your email.");
	            }
	        } else {
	            out.println("Upload successful, but no user email found .");
	        }
	        
	        
	        out.close();
	    }
	private boolean sendGmail(String userEmail) {
        final String email = "mucyohubert300m@gmail.com";
        final String password = "bbbjitiqyplqlhpl";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(email, password);
                }
            });

        try {
           
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(email));
            message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(userEmail));

            message.setSubject(" Student Files Upload Confirmation");
            message.setText("This is Upload Comfirmation for you! Photos Uploaded Successfully.");

            Transport.send(message);

            return true; 
        } catch (MessagingException e) {
            e.printStackTrace();
            return false; 
        }
    }

}
