<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
        <link href="${bootstrapCss}" rel="stylesheet" />
        <meta charset="utf-8">
        <title>Онлайн магазин</title>
    </head>
    <body>
        <div class = "container">
            <h1>Книги</h1>
            <table class="table table-hover table-striped" width="500">
                <thead>
                    <tr>
                        <th>#ID</th>
                        <th>Name</th>
                        <th>Author</th>
                        <th>Supplier</th>
                        <th>Price</th>
                        <th>Image</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <c:forEach var="product" items="${products}">
                                <tr>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.author}</td>
                                <td>${product.supplierId}</td>
                                <td>${product.price}</td>
                                <td>${product.image}</td>
                                <td>${product.description}</td>
                                <td>

                                </td>
                      </tr>
                 </c:forEach>
            </table>
            <br>
            <a href="/spring3/addProductForm">Добавление книги</a>
        </div>
    </body>
</html>