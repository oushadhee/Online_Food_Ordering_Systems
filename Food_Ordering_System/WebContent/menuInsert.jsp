<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Menu Item</title>
     <link rel="stylesheet" type="text/css" href="menuUpdate.css"> 
</head>
<body>

    <%@ include file="header.jsp" %> 

    <h1>Add Menu Item</h1> 
    <form action="InsertMenuServlet" method="post" >
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea><br>
        
        <label for="price">Price:</label>
        <input type="text" id="price" name="price"  required><br>
        
         <label for="category">Category:</label>
        <select id="category" name="category">
            <option value="appetizers">Appetizers</option>
            <option value="main_courses">Main Courses</option>
            <option value="desserts">Desserts</option>
        </select><br>
        
        <label for="availability">Availability:</label>
        <input type="checkbox" id="availability" name="availability" value="available">
        
        
        
        <input type="submit" value="Add Menu Item">
    </form>
</body>
</html>

