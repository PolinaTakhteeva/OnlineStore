<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Добавление книги</title>
    </head>
    <body>
        <h1>Добавление книги</h1>

        	<form action="/spring3/addProduct" method="post" object="{product}">
        	    Название книги
                <input type="text" field = "*{name}"   name="name" id="name-field">
                <br>
                <br>
                Имя автора
                <input type="text" field = "*{author}" name="author" id="author-field">
                <br>
                <br>
                <input type = "submit" value = "Добавить книгу">
            </form>
    </body>
</html>