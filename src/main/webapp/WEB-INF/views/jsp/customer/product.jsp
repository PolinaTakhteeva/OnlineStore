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
        <spring:url value="/resources/core/css/product.css" var="productCss" />
                <link href="${productCss}" rel="stylesheet" />
                <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
                                 <link href="${bootstrapCss}" rel="stylesheet" />
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
    				<h1></span>Информация о товаре</h1>

    				<nav class='nav'>
    					<a class='nav__item nav__item_left' href="index.html" class="current"></a>
    					<a class='nav__item' href="grid.html"></a>
    					<a class='nav__item' href="/spring3/cabinet">Личный кабинет</a>
    					<a class='nav__item' href="/spring3/card">Корзина</a>
    				</nav>

    			</header>
    			        <div class="wrapper1">

                            <div class="content-container clearfix">
                                <div class="sidebar">
                                    <img width="350" height="500" src="${pageContext.servletContext.contextPath}${product.image}" alt="">
                                </div>
                                <div class="content">
                                    <div class="content-right">
                                        <div class="product-text">
                                            <h2 class="produvt-name">${product.name}</h2>
                                            <div class="product-availability"><span class="icon icon-check"></span>${product.author}</div>
                                            <p> ${product.description}</p>
                                        </div>
                                        <div class="product-details-wrap">
                                            <div class="product-details">
                                                <div class="product-availability">
                                                <span class="icon icon-check"></span>
                                                <span>В наличии</span>
                                                </div>
                                                    <span class="product-price">
                                                        <b>${product.price}</b>
                                                        <small>руб.</small>
                                                    </span>
                                                    <br>
                                                    <br>

                                                    <spring:url value="/addToCard/${product.id}" var="addToCard" />
                                                    <button class="btn btn-success" onclick="post('${addToCard}')">Добавить в корзину</button>
                                                    <br>
                                                    <br>
                                                    <br>

                                                    <form action="/spring3/addToCard/${product.id}" method="post" object="{product.id}">
                                                    <input type = "submit" value = "Добавить в корзину">
                                                     </form>

                                                    <!--
                                                    <div class="button to-cart"></div>
                                                    -->
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                <div class="footer"></div>
            </div>
    </body>
</html>