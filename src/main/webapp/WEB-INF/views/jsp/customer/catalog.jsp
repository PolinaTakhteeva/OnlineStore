<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/core/css/main.css" var="mainCss" />
                <link href="${mainCss}" rel="stylesheet" />
        <spring:url value="/resources/core/css/demo.css" var="demoCss" />
                <link href="${demoCss}" rel="stylesheet" />
        <meta charset="utf-8">
        <title>Онлайн магазин</title>
    </head>
    <body>
    		<div class="wrapper">
    			<header>
    				<div class="layout-buttons">
    					<span class="active icon icon-list"></span>
    		            		<span class="icon icon-table"></span>
    				</div>
    				<h1></span>Список товаров</h1>

    				<nav class='nav'>
    					<a class='nav__item nav__item_left' href="" class="current"></a>
    					<a class='nav__item' href="grid.html"></a>
    					<a class='nav__item' href="/spring3/cabinet">Личный кабинет</a>
    					<a class='nav__item' href="/spring3/card">Корзина</a>
    				</nav>

    			</header>

    			<ul class="products clearfix">
    			<c:forEach var="product" items="${products}">
    				<li class="product-wrapper">
    					<a href="/spring3/catalog/${product.id}" class="product">
    						<div class="product-main">
    							<div class="product-photo">
    								<img src="${pageContext.servletContext.contextPath}${product.image}" alt="">
    								<div class="product-preview">
    								        <span class="button">Просмотр</span>
    								</div>
    							</div>
    							<div class="product-text">
    								<h2 class="produvt-name">${product.name}</h2>
    								<p>${product.description}</p>
    							</div>
    						</div>
    						<div class="product-details-wrap">
    							<div class="product-details">
    								<div class="product-availability"><span class="icon icon-check"></span>В наличии</div>
    								<span class="product-price">
    									<b>${product.price}</b>
    									<small>руб.</small>
    								</span>
    							</div>
    							<div class="product-buttons-wrap">
    								<div class="buttons">
    									<span class="button-new">В корзину</span>
    								</div>
    							</div>
    						</div>
    					</a>
    				</li>
    				</c:forEach>
    </body>
</html>