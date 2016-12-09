<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Онлайн магазин</title>
    </head>
    <body>
        <h1>Книги</h1>
        <p>
            ${allProducts}
        </p>
        <table class="table table-striped"  border="4" cellpadding="5" width="500">
            <thead>
                <tr>
                    <th>#ID</th>
                    <th>Name</th>
                    <th>Author</th>
                </tr>
            </thead>
            <c:forEach var="product" items="${products}">
                            <tr>
                            <td>${product.id}</td>
                            <td>${product.name}</td>
                            <td>${product.author}</td>
                            <td>

                            </td>
                  </tr>
             </c:forEach>
        </table>
        <br>
        <a href="/spring3/addProductForm">Добавление книги</a>

    </body>
</html>