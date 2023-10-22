package com.Cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Call the method to retrieve cart items from the database
        List<CartItem> cartItems = DBUtil.getCartItems();

        // Set the cart items as an attribute in the request
        request.setAttribute("cartItems", cartItems);

        // Forward the request to the viewCart.jsp page
        request.getRequestDispatcher("viewCart.jsp").forward(request, response);
    }
}
