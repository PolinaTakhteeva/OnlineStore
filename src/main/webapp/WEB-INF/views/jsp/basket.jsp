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
    				<h1></span>Корзина</h1>

    				<nav class='nav'>
    					<a class='nav__item nav__item_left' href="/basket" class="current"></a>
    					<a class='nav__item' href="grid.html"></a>
    					<a class='nav__item' href="/spring3/cabinet">Личный кабинет</a>
    					<a class='nav__item' href="/spring3/basket">Корзина</a>
    				</nav>
    			</header>
    	    </div>
    	    <div class="wrapper1">
                <div class="content-container clearfix">
                    <h2 class="produvt-name">Корзина пока пуста</h2>
                </div>
            </div>
    </body>
</html>