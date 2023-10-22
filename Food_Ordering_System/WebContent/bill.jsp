<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bill</title>
    <link rel="stylesheet" type="text/css" href="Bill.css"> <!-- Include the CSS file -->
</head>
<body>
    <div class="bill-container">
        <h1>Bill</h1>

        <h2>Cart Items:</h2>
        <table>
            <tr>
                <th>Food ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total Price</th>
            </tr>
            <c:forEach items="${cartItems}" var="cartItem">
                <tr>
                    <td>${cartItem.menuId}</td>
                    <td>${cartItem.name}</td>
                    <td>${cartItem.price}</td>
                    <td>${cartItem.quantity}</td>
                    <td>${cartItem.price * cartItem.quantity}</td>
                </tr>
            </c:forEach>
        </table>

        <h2>Total Bill Amount:</h2>
        <p>${totalBill}</p>
    </div>
    <a href="home.jsp" class="back-button">
    <img src="images/home.png" alt="Home" width="40" height="40">
</a>
    
    
</body>
</html>
