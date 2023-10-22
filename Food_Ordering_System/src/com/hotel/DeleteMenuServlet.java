package com.hotel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteMenuServlet")
public class DeleteMenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int menuId = Integer.parseInt(request.getParameter("menu_id"));


        boolean isDeleted = DBUtil.deleteMenuItem(menuId);

        if (isDeleted) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("unsuccess.jsp");
        }
    }
}
