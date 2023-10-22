<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Menu Item</title>
  	 <link rel="stylesheet" type="text/css" href="menuUpdate.css"> 
</head>
<body>
    <%@ include file="header.jsp" %>

    <h1>Update Menu Item</h1>

    <form action="UpdateMenuServlet" method="post">
        <label for="menu_id">Menu Item ID to Update:</label>
        <input type="text" id="menu_id" name="menu_id" required value="${param.menu_id}"><br>

        <label for="menu_item_name">New Menu Item Name :</label>
        <input type="text" id="menu_item_name" name="menu_item_name" required><br>

        <label for="new_description">New Description:</label>
        <textarea id="new_description" name="new_description" required></textarea><br>

        <label for="new_price">New Price:</label>
        <input type="text" id="new_price" name="new_price" required><br>
        
         <label for="category">Category:</label>
        <select id="category" name="category">
            <option value="appetizers">Appetizers</option>
            <option value="main courses">Main Courses</option>
            <option value="desserts">Desserts</option>
        </select><br><br><br>

        <label for="availability">Availability:</label>
        <input type="checkbox" id="availability" name="availability" value="available" checked> Available<br><br>
        

        <input type="submit" value="Update Menu Item">
    </form>
</body>
</html>
