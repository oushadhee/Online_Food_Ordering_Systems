package com.Cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateQuantityServlet")
public class UpdateQuantityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the item ID and new quantity from the form
        int itemId = Integer.parseInt(request.getParameter("id"));
        int newQuantity = Integer.parseInt(request.getParameter("quantity"));

        // Update the quantity in the database using the DBUtil class
        boolean updateSuccess = DBUtil.updateCartItemQuantity(itemId, newQuantity);

        if (updateSuccess) {
            // Redirect back to the cart view after a successful update
            response.sendRedirect("view");
        } else {
            // Handle the case where the update fails, you can redirect to an error page or handle it as needed
            response.sendRedirect("error.jsp");
        }
    }
}
