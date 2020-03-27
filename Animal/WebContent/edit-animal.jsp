<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<form action = "editAnimalServlet" method = "post">
Type: <input type= "text" name ="type" value = "${itemToEdit.type}">
Area: <input type= "text" name ="area" value = "${itemToEdit.area}">
<input type = "hidden" name = "id" value = "${itemToEdit.id}">
<input type = "submit" value = "Save Edited Item">
</form>

</body>
</html>

