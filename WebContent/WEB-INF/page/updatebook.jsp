<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>书籍上架</title>
<style>
	.formDiv{
		width: 70%;
		
		margin-left: 15%;
		border:1px #DFDFDF solid;
		text-align: center;
		margin-top: 10%;
		padding-top: 5%;
		padding-bottom:5%;
	}
	.formDiv input{
		width: 200px;
		height: 30px;
		outline: none;
		border:1px #EEEEEE solid;
		border-radius: 5px;
	}
	.formDiv input:focus{
		border:1px #46BCAF solid;
	}
	.formDiv .btn{
		background-color: #EEEEEE;
		color:#000;
	}
	.formDiv .btn:hover{
		background-color: #46BCAF;
		color: #fff;
		cursor: pointer;
		border:1px #46BCAF solid;
	}
	.top{
		width: 100%;
		border:0px solid red;
		height: 1%;
		font-size: 14px;
		color: red;
	}
</style>
</head>
<body>
	<div class="formDiv"><!-- 修改书籍的servlet -->
		<form action="/WebBook/book/doupdate" method="post">
			<input type="text" name="bno" value = ${currBook.bno } placeholder="书籍编号"/>
			<br/><br/>
			<input type="text" name="bname" value = ${currBook.bname } placeholder="书籍名称"/>
			<br><br/>
			<input type="text" name="author" value = ${currBook.author } placeholder="作者"/>
			<br><br/>
			<input type="text" name="price" value = ${currBook.price } placeholder="价格"/>
			<br><br/>
			<input type="text" name="mark" value = ${currBook.mark } placeholder="简介"/>
			<br><br/>
			<input type="submit" value="确认" class="btn">
		</form>
	</div>
</body>
</html>