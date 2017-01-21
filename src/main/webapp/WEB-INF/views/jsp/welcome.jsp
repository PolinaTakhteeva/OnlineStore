<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Онлайн магазин</title>
         <spring:url value="/resources/core/css/animate.css" var="animateCss" />
                          <link href="${animateCss}" rel="stylesheet" />
         <spring:url value="/resources/core/css/style.css" var="styleCss" />
                          <link href="${styleCss}" rel="stylesheet" />

    </head>
    <body>
        <div class="page-title top-content background" style="position: relative; z-index: 0;">
                    <div class="page-title-text wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">
                    	<h1>Добро пожаловать в книжный магазин!</h1>
                    	<p>Книжный магазин  – сайт, где можно дешево купить книги (в том числе, новинки и бестселлеры)!</p>
                    	<div class="page-title-bottom-link">
                    		<a class="big-link-1 btn scroll-link" href="/spring3/catalog">Перейти к покупкам</a>

                    	</div>
                    </div><br>
        <div class="backstretch" style="left: 0px; top: 0px; overflow: hidden; margin: 0px; padding: 0px; height: 636px; width: 517px; z-index: -999998; position: absolute;">

     </body>
 </html>