 package com.payment.servlet;
 
  import java.io.IOException; import java.util.List;
  
 import javax.servlet.RequestDispatcher; import
 javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet; import
 javax.servlet.http.HttpServletRequest; import
 javax.servlet.http.HttpServletResponse;

import com.payment.util.PaymentDBUtil;
import com.payment.model.Card;
 
 @WebServlet("/PaymentRetrieve") public class PaymentRetrieveServlet extends
 HttpServlet { private static final long serialVersionUID = 1L;
 

protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  List<Card> customers = PaymentDBUtil.retrieveCustomers();

  request.setAttribute("customers", customers);
  RequestDispatcher dispatcher = request.getRequestDispatcher("paymentretrieve.jsp");
  dispatcher.forward(request, response);

}
 }
		
