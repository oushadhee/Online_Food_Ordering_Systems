package com.hotel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateMenuServlet")
public class UpdateMenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	int menuID = Integer.parseInt(request.getParameter("menu_id"));
    	String menuItemName = request.getParameter("menu_item_name");
    	String newDescription = request.getParameter("new_description");
    	String newPrice = request.getParameter("new_price");
    	double newPriceValue = Double.parseDouble(newPrice);
    	String newCategory = request.getParameter("new_category");
    	String newAvailabilityParam = request.getParameter("new_availability");
    	boolean newAvailability = newAvailabilityParam != null && newAvailabilityParam.equals("true");

        boolean isUpdated = DBUtil.updateMenuItem(menuID, menuItemName, newDescription, newPriceValue, newCategory, newAvailabilityParam);

        if (isUpdated) {
        	response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<script type='text/javascript'>");
	        out.println("alert('Menu item updated successfully!');");
	        out.println("window.location='DisplayMenuServlet';"); 
	        out.println("</script>");
        } else {
        	response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<script type='text/javascript'>");
	        out.println("alert('Menu item insertion failed!');");
	        out.println("window.location='menuUpdate.jsp';"); 
	        out.println("</script>");
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doGet(request, response);
    }
}
