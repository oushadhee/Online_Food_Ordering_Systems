package com.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.model.User;
import com.user.util.UserDBUtil;


@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("usrid");
		boolean isTrue;
		
		isTrue = UserDBUtil.deleteUser(id);
		
		if(isTrue== true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("userinsert.jsp");
			dispatcher.forward(request, response);
		}
		else {
			List<User> usrDetails = UserDBUtil.getUserDetails(id);
			request.setAttribute("usrDetails", usrDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("useraccount.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
