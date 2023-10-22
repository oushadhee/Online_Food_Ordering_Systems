package com.Cart;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertCartServlet")
public class InsertCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        
        int menuId = Integer.parseInt(request.getParameter("itemId")); 
        String itemName = request.getParameter("itemName");
        double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
        int quantity = 1; 
        
       

        
        boolean insertionSuccess = DBUtil.insertCartItem( menuId, itemName, itemPrice, quantity);

        if (insertionSuccess) {
           
            response.sendRedirect("success.jsp");
        } else {
            
            response.sendRedirect("error.jsp");
        }
    }

    }

