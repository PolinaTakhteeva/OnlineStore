<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/WEB-INF/views/jsp/fragments/header.jsp" />
    <body>
    	    <div class="wrapper1">
                <h1>Ваш заказ</h1>
                            <table class="table table-hover table-striped" width="500">
                                <thead>
                                    <tr>
                                        <th>#ID</th>
                                        <th>Количество</th>
                                    </tr>
                                </thead>
                                <c:forEach var="product" items="${card}">
                                        <tr>
                                            <td>${product.key}</td>
                                            <td>${product.value}</td>
                                        </tr>
                                 </c:forEach>
                            </table>
                            <br>
            </div>
    </body>
</html>