<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu List</title>
 <link rel="stylesheet" type="text/css" href="menuList.css"> 
</head>
<body>
    <%@ include file="header.jsp" %>

    <h1>Menu List</h1>
    
    <div class="table-container">

    <table border="1">
        <tr>
            <th>MENU_ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Category</th> 
            <th>Availability</th> 
            <th>Actions</th>
        </tr>
        <c:forEach items="${menuItems}" var="menuItem">
            <tr>
                <td>${menuItem.id}</td>
                <td>${menuItem.name}</td>
                <td>${menuItem.description}</td>
                <td>${menuItem.price}</td>
                <td>${menuItem.category}</td> 
                <td>${menuItem.availability}</td> 
                <td>
                    <button onclick="deleteMenuItem(${menuItem.id})">Delete</button>
                    <button onclick="updateMenuItem(${menuItem.id})">Update</button>
                </td>
            </tr>
        </c:forEach>
    </table>
<button id="backToHomeButton" onclick="window.location.href='hoteladmin.jsp'">Back to Home</button>
    <script>
        function deleteMenuItem(menuId) {
            var confirmDelete = confirm("Are you sure you want to delete this item?");
            if (confirmDelete) {
                var xhr = new XMLHttpRequest();
                xhr.open("POST", "DeleteMenuServlet", true);
                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        var deletedRow = document.querySelector('button[data-menuid="' + menuId + '"]').closest('tr');
                        deletedRow.parentNode.removeChild(deletedRow);
                    }
                };
                xhr.send("menu_id=" + menuId);
            }
        }

        function updateMenuItem(menuId) {
            window.location.href = "menuUpdate.jsp?menu_id=" + menuId;
        }
    </script>
    
   </div>

    
</body>
</html>
