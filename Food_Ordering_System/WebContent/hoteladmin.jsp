<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hotel Admin Interface</title>
    <link rel="stylesheet" type="text/css" href="hoteladmin.css">
</head>
<body>

  <jsp:include page="header.jsp" />

    <header>
        <h1>Hello Hotel Admin !</h1>
    </header>
    <nav>
        <ul>
            <li><a href="menuInsert.jsp">Insert Menu</a></li>
            <li><a href="DisplayMenuServlet">View Menu</a></li>
        </ul>
    </nav>
    <main>
        <section id="insert">
           
        </section>
        
        <section id="view">
        <a href="retrieve"></a>
        </section>
            
        
    </main>
</body>
</html>
