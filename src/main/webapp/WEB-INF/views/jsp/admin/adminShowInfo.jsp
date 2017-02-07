<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<jsp:include page="/WEB-INF/views/jsp/fragments/header.jsp" />

<div class="container">

	<h1>Информация о товаре</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${product.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Название</label>
		<div class="col-sm-10">${product.name}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Автор</label>
		<div class="col-sm-10">${product.author}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Издательство</label>
		<div class="col-sm-10">${product.supplierId}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Цена</label>
		<div class="col-sm-10">${product.price}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Адрес изображения</label>
		<div class="col-sm-10">${product.image}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Описание товара</label>
		<div class="col-sm-10">${product.description}</div>
	</div>

	<div class="row">
    	<label class="col-sm-2">Количество</label>
    	<div class="col-sm-10">${product.count}</div>
    </div>


</div>
</body>
</html>