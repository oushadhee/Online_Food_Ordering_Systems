<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu List</title>
    <link rel="stylesheet" type="text/css" href="menuList.css">
    <style>
        /* Additional styles for improved layout */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
        }

        th {
            background-color: #333;
            color: #fff;
        }

        .add-to-cart-link {
            display: inline-block;
            background-color: #4CAF50;
            color: #fff;
            padding: 8px 12px;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        .add-to-cart-link:hover {
            background-color: #45a049;
        }

        .view-cart-button {
            text-align: center;
            margin: 20px;
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>

    <h1>Menu List</h1>

    <table>
        <tr>
            <th>MENU_ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${menuItems}" var="menuItem">
            <tr>
                <td>${menuItem.id}</td>
                <td>${menuItem.name}</td>
                <td>${menuItem.description}</td>
                <td>${menuItem.price}</td>
                <td>
                    <a class="add-to-cart-link"
   						href="cartinsert?itemId=${menuItem.id}&itemName=${menuItem.name}&itemPrice=${menuItem.price}">
  						 Add To Cart
					</a>
                    
                </td>
            </tr>
        </c:forEach>
    </table>

    <div class="view-cart-button">
        <a class="add-to-cart-link" href="view">View Cart</a>
    </div>
</body>
</html>
