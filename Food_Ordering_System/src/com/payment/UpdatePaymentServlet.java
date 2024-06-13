package com.payment.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payment.model.Card;
import com.payment.util.PaymentDBUtil;


@WebServlet("/UpdatePaymentServlet")
public class UpdatePaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String amount = request.getParameter("amount");
        String cardNumber = request.getParameter("cardNumber");
        String exdate = request.getParameter("exdate");
        String cvv = request.getParameter("cvv");

        boolean isSuccess;
         isSuccess = PaymentDBUtil.updatecustomer(id, amount, cardNumber, exdate, cvv);

        if (isSuccess == true) {
        	List<Card> cusDetails = PaymentDBUtil.getCustomerDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("payment.jsp");
			dis.forward(request, response);
			
            
            

            
        } else {
        	List<Card> cusDetails = PaymentDBUtil.getCustomerDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			
			
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);;
        }
    }
}