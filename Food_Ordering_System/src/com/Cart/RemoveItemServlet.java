package com.Cart;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RemoveItemServlet")
public class RemoveItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the item ID to be removed from the request parameters
        int itemId = Integer.parseInt(request.getParameter("id"));
        
        // Call a method to remove the item from the database
        boolean removalSuccess = DBUtil.removeItem(itemId);

        if (removalSuccess) {
            // Redirect to a success page or back to the cart page
            response.sendRedirect("success.jsp");
        } else {
            // Redirect to an error page
            response.sendRedirect("error.jsp");
        }
    }
}
