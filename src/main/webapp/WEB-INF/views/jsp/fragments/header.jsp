<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <head>
        <spring:url value="/resources/core/css/main.css" var="mainCss" />
                <link href="${mainCss}" rel="stylesheet" />
        <spring:url value="/resources/core/css/demo.css" var="demoCss" />
                <link href="${demoCss}" rel="stylesheet" />
        <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
                 <link href="${bootstrapCss}" rel="stylesheet" />
        <meta charset="utf-8">
        <title>Онлайн магазин</title>
    </head>

    		<div class="wrapper">
    			<header>
    				<div class="layout-buttons">
    					<span class="active icon icon-list"></span>
    		            		<span class="icon icon-table"></span>
    				</div>
    				<h1></span>Онлайн магазин</h1>

    				<nav class='nav'>
    					<a class='nav__item nav__item_left' href="/basket" class="current"></a>
    					<a class='nav__item' href="grid.html"></a>
    					<a class='nav__item' href="/spring3/cabinet">Личный кабинет</a>
    					<a class='nav__item' href="/spring3/card">Корзина</a>
    				</nav>
    			</header>
    		</div>