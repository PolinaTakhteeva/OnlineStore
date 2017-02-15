<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/WEB-INF/views/jsp/fragments/header.jsp" />
    <body>
    	    <div class="wrapper1">
                <h1>Корзина</h1>
                            <table class="table table-hover table-striped" width="500">
                                <thead>
                                    <tr>
                                        <th>Название</th>
                                        <th>Автор</th>
                                        <th>Цена</th>
                                        <th>Количество</th>
                                    </tr>
                                </thead>
                                <c:forEach var="product" items="${cardProducts}">
                                        <tr>
                                            <td>${product.key.name}</td>
                                            <td>${product.key.author}</td>
                                            <td>${product.key.price}</td>
                                            <td>${product.value}</td>
                                        </tr>
                                 </c:forEach>
                            </table>
                            <br>
                <h2>К оплате: ${coast} руб.</h2>
                <br>
                <form action="/spring3/addOrder" method="post" object="{cardProducts}">
                <input type = "submit" value = "Оформить заказ">
                </form>
                <spring:url value="/addOrder" var="addOrder" />
                <button class="btn btn-success" onclick="post('${addOrder}')">Оформить заказ</button></td>
            </div>
    </body>
</html>