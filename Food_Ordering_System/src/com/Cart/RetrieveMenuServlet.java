package com.Cart;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RetrieveMenuServlet")
public class RetrieveMenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
        List<MenuItem> menuItems = DBUtil.retrieveMenuItems();

        request.setAttribute("menuItems", menuItems);
        request.getRequestDispatcher("CustomerMenuList.jsp").forward(request, response);
    }
}
