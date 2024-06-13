package com.payment.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payment.util.PaymentDBUtil;

import java.io.PrintWriter;

@WebServlet("/PaymentInsert")
public class PaymentInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String amount = request.getParameter("amount");
        String cardNumber = request.getParameter("cardNumber");
        String exdate = request.getParameter("exdate");
        String cvv = request.getParameter("cvv");

      
        boolean isSuccess = PaymentDBUtil.insertcustomer(amount, cardNumber, exdate, cvv);

        if (isSuccess) {
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Successfully added to your details!');");
            out.println("location='paymentinsert.jsp';");
            out.println("</script>");
        } else {
            response.sendRedirect("unsuccess.jsp");
        }
    }
}