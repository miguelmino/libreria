<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>libreria</title>
</head>
<body>
    <h1>Lista de libros</h1>
    <ul>
        <c:forEach var="libro" items="${libros}">
            <li>Titulo: ${libro.titulo} - Autor:  ${libro.autor} - ISBN: ${libro.isbn}</li>
        </c:forEach>
    </ul>
    
    <form:form method="post" action="addBook" commandName="libro">
  
    <table>
    <tr>
        <td><form:label path="titulo">Titulo:</form:label></td>
        <td><form:input path="titulo" /></td>
    </tr>
    <tr>
        <td><form:label path="autor">Autor:</form:label></td>
        <td><form:input path="autor" /></td>
    </tr>
    <tr>
        <td><form:label path="isbn" >ISBN:</form:label></td>
        <td><form:input path="isbn" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" />
        </td>
    </tr>
</table> 
</form:form>
    
    
</body>
</html>