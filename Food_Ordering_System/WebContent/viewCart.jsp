<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Cart</title>
    <style>
    
        .quantity-input {
            width: 30px;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="viewCart.css">
</head>
<body>
<div class = "container">
    <h1>Cart Items</h1>

    <table>
        <tr>
            <th>Cart ID</th>
            <th>Food ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${cartItems}" var="cartItem">
            <tr>
                <td>${cartItem.id}</td>
                <td>${cartItem.menuId}</td>
                <td>${cartItem.name}</td>
                <td>${cartItem.price}</td>

                <td>
                    <form action="Quantity" method="post">
                        <input class="quantity-input" type="number" name="quantity" value="${cartItem.quantity}" oninput="validatePositiveNumber(this)">
                        <input type="hidden" name="id" value="${cartItem.id}">
                        <input type="submit" value="Update Quantity">
                    </form>
                </td>

                <td>
                    <form action="RemoveItemServlet" method="get">
                        <input type="hidden" name="id" value="${cartItem.id}">
                        <button type="button" onclick="confirmCancellation(this)">Cancel Order</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
	</div>
    <script>
        function confirmCancellation(button) {
            if (confirm("Are you sure you want to cancel this order?")) {
                // Submit the form when the user confirms
                button.form.submit();
            }
        }

        function validatePositiveNumber(input) {
            const value = input.value;
            if (isNaN(value) || value <= 0) {
                alert("Please enter a positive number for quantity.");
                input.value = ''; // Clear the input
            }
        }
    </script>

    <form action="generateBill" method="post">
        <button type="submit">Order Now</button>
    </form>
</body>
</html>
