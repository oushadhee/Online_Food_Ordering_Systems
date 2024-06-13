package com.payment.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.payment.util.PaymentDBUtil;


@WebServlet("/DeletePaymentServlet")
public class DeletePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        String id = request.getParameter("id");
	        
	        boolean isTrue;

	        isTrue = PaymentDBUtil.deleteCustomer(id);
	        if (isTrue == true) {
	        	
	        	List<com.payment.model.Card> cusDetails = PaymentDBUtil.getCustomerDetails(id);
	            request.setAttribute("cusDetails", cusDetails);

	            RequestDispatcher dispatcher = request.getRequestDispatcher("payment.jsp");
	            dispatcher.forward(request, response);
	        	
	        	  
	        } else {
	        	List<com.payment.model.Card> cusDetails = PaymentDBUtil.getCustomerDetails(id);
	            request.setAttribute("cusDetails", cusDetails);

	            RequestDispatcher dispatcher = request.getRequestDispatcher("unsuccess.jsp");
	            dispatcher.forward(request, response);
	        }
	    }
}
