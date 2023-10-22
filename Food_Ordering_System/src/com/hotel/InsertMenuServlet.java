package com.hotel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertMenuServlet")
public class InsertMenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	    String name = request.getParameter("name");
    	    String description = request.getParameter("description");
    	    String price = request.getParameter("price");
    	    double value = Double.parseDouble(price);
    	    String category = request.getParameter("category"); 
    	    boolean availability = request.getParameter("availability") != null; 

    	    boolean isTrue;

    	
    	    isTrue = DBUtil.insertMenuItem(name, description, value, category, availability);

    	    if (isTrue) {
    	       
    	        response.setContentType("text/html");
    	        PrintWriter out = response.getWriter();
    	        out.println("<script type='text/javascript'>");
    	        out.println("alert('Menu item inserted successfully!');");
    	        out.println("window.location='DisplayMenuServlet';"); 
    	        out.println("</script>");
    	    } else {
    	       
    	        response.setContentType("text/html");
    	        PrintWriter out = response.getWriter();
    	        out.println("<script type='text/javascript'>");
    	        out.println("alert('Menu item insertion failed!');");
    	        out.println("window.location='menuInsert.jsp';"); 
    	        out.println("</script>");
    	    }

    }
}
