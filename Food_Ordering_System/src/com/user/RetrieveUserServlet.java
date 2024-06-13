package com.user.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.model.User;
import com.user.util.UserDBUtil;


@WebServlet("/RetrieveUserServlet")
public class RetrieveUserServlet extends HttpServlet {
	

	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
	    	HttpSession session = request.getSession();
	    	String username = (String) session.getAttribute("username");

	    	if (session != null && username != null) {
	    	   
	    	    List<User> usrDetails = UserDBUtil.getUser(username);
	    	    request.setAttribute("usrDetails", usrDetails);

	    	    RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
	    	    dis.forward(request, response);
	    	} else {
	    	  
	    	    response.getWriter().println("Invalid or missing username or session.");
	    	}

	    }
	}

		
		
	


