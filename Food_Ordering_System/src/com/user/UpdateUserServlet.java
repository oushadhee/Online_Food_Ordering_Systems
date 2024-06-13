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


@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("usrid");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		boolean isTrue;
		
		isTrue = UserDBUtil.updateuser(id, name,gender, email, phone, address,username, password);
	
	    if(isTrue == true) {
	    	
	    	List<User> usrDetails = UserDBUtil.getUserDetails(id);
	    	request.setAttribute("usrDetails",usrDetails );
	    	
	    	RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
	    	dis.forward(request,response);
	    }
	    else {
	    	
	    	List<User> usrDetails = UserDBUtil.getUserDetails(id);
	    	request.setAttribute("usrDetails",usrDetails );
	    	
	    	RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
	    	dis.forward(request,response);
	    }
	
	}

}
