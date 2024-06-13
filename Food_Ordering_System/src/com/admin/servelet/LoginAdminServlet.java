package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.util.AdminDBUtil;




@WebServlet("/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		boolean isTrue;
		
		isTrue = AdminDBUtil.validate(username,password );
		
		if(isTrue == true) {
			//List<Admin> admDetails = AdminDBUtil.getAdminDetails(username);
			//request.setAttribute("admDetails", admDetails);
			request.getSession().setAttribute("username", username);

			
			RequestDispatcher dis = request.getRequestDispatcher("hoteladmin.jsp");
			dis.forward(request, response);
		}else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location = 'adminlogin.jsp'");
			out.println("</script>");
		}
		
		
		
		
		
	}

}
