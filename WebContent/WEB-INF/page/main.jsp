<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页</title>
<style>
	*{
		margin:0;
		padding:0;
	}
	.main{
		margin-top:50px;
		width:80%;
		margin-left:10%;
		border:0px #DFDFDF solid;
		text-align: center;
	}
	table,th,td{
		border:1px #46BCAF solid;
	}
	.btn{
		display: inline-block;
		height: 30px;
		background-color: #EEEEEE;
		text-decoration: none;
		line-height: 30px;
		color: #000;
		
	}
	.btn:hover{
		background-color: #46BCAF;
		color: #fff;
	}
	table{
		border-collapse: collapse;
		width: 90%;
		margin-left: 5%;
	}
	table .btn{
		width: 70px;
	}
	.addDiv{
		
		text-align: left;
		width: 90%;
		margin-left:5%;
		margin-bottom:30px;
	}
	.addDiv a{
		width: 100px;
		text-align: center;
	}
	.top_search{
		display: inline-block;
		height: 30px;
		margin-left:30%;
	}
	.top_search_btn{
		display: inline-block;
		height: 30px;
		background-color: #EEEEEE;
		text-decoration: none;
		line-height: 30px;
		color: #000;
	}
</style>
</head>
<body>
	<div class="main">
		<div class="addDiv">
			<!-- 请求添加书籍页面 -->
			<a href="/WebBook/book/add" class="btn">新书上架</a>
			
			<input type = "text" class = "top_search" placeholder = "请输入想要查找的书籍">
			<a href ="/webBook/book/search?" class = "top_search_btn">搜索</a>
		</div>
		
		<table>
			<tr>
				<th>编号</th>
				<th>书名</th>
				<th>作者</th>
				<th>价格</th>
				<th>简介</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${books }" var="book">
				<tr>
					<td>${book.bno }</td>
					<td>${book.bname }</td>
					<td>${book.author }</td>
					<td>${book.price }</td>
					<td>${book.mark }</td>
					<td>
						<a href="/WebBook/book/update?id=${book.id }" class="btn">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="/WebBook/book/del?id=${book.id}" class="btn">删除</a>
					</td>
					<!-- 修改思路：
					1.通过id找到这本书籍的信息，
					2.旧的信息回显到页面的表单中
					3.在页面上修改信息
					4.提交到后台，获取新的书籍信息，完成修改功能
					5.显示所有书籍最新信息-->
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>