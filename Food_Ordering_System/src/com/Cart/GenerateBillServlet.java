package com.Cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GenerateBillServlet
 */
@WebServlet("/GenerateBillServlet")
public class GenerateBillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve cart items from the database using your DBUtil class
        List<CartItem> cartItems = DBUtil.getCartItems();
        
        // Calculate the total bill
        double totalBill = calculateTotalBill(cartItems);

        // Set the cartItems and totalBill as attributes to pass to the bill.jsp page
        request.setAttribute("cartItems", cartItems);
        request.setAttribute("totalBill", totalBill);

        // Forward to the bill.jsp page to display the bill
        request.getRequestDispatcher("bill.jsp").forward(request, response);
    }

    private double calculateTotalBill(List<CartItem> cartItems) {
        double totalBill = 0.0;
        for (CartItem cartItem : cartItems) {
            totalBill += cartItem.getPrice() * cartItem.getQuantity();
        }
        return totalBill;
    }
}

    