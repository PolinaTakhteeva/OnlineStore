<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/jsp/fragments/header.jsp" />
    <head>
        <title>Онлайн магазин</title>
    </head>
    <body>
        <div class = "container">
            <h1>Книги</h1>
            <table class="table table-hover table-striped" width="500">
                <thead>
                    <tr>
                        <th>#ID</th>
                        <th>Название</th>
                        <th>Автор</th>
                        <th>Цена</th>
                    </tr>
                </thead>
                <c:forEach var="product" items="${products}">
                                <tr>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.author}</td>
                                <td>${product.price} руб.</td>
                                <td><c:forEach var="framework" items="${user.framework}" varStatus="loop">
                                						${framework}
                                    					<c:if test="${not loop.last}">,</c:if>
                                						</c:forEach></td>
                                					<td>
                                						<spring:url value="/admin/${product.id}" var="productUrl" />
                                						<spring:url value="/admin/${product.id}/delete" var="deleteUrl" />
                                						<spring:url value="/users/${user.id}/update" var="updateUrl" />

                                						<button class="btn btn-info" onclick="location.href='${productUrl}'">Query</button>
                                						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                                						<button class="btn btn-success" onclick="location.href='${deleteUrl}'">Delete</button></td>
                                				</tr>

                 </c:forEach>
            </table>
            <br>
            <a href="/spring3/addProductForm">Добавление книги</a>
        </div>
    </body>
</html>