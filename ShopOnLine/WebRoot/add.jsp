<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="cn.ac.ict.ShopOnLine.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#amountId").change(function(){
			var value = $("#amountId").val();
			var value = parseInt(value);
			var price = ${sessionScope.pro.realprice};
			var total = price*value;
			$("#totalprice").html(total);
		});
	})
</script>
<title>购买商品</title>
</head>
<body>
<form action="AddItemsServlet" method="get">
	<table border=1 align=center>
	<caption><strong>修改购买商品数量并把它们加入到您的购物车</strong></caption>
		<tr>
			<td>商品名称</td>
			<td>产地</td>
			<td>生产公司</td>
			<td>市场价</td>
			<td>优惠价</td>
			<td>库存</td>
			<td>购买数量</td>
			<td>小计</td>
		</tr>
		<tr>
			<td>${sessionScope.pro.pname}</td>
			<td>${sessionScope.pro.pmadew}</td>
			<td>${sessionScope.pro.pcomp}</td>
			<td>${sessionScope.pro.realprice}</td>
			<td>${sessionScope.pro.cutprice}</td>
			<td>充足<input type="hidden" name="pid" value="${sessionScope.pro.pid}"></td>
			<td><input type="text" size=2 name="amount" value=1 id="amountId"><button onclick="return false">确定</button></td>
			<td id="totalprice">${sessionScope.pro.realprice*1}</td>
		</tr>
		<tr>
			<td colspan="4" align="center"><a href="list.jsp"><h4 align="center">先不买这个商品</h4></a></td>
			<td colspan="3" align="center"><a href="showcart.jsp"><h4 align="center">查看购物车</h4></a></td>
			<td align="center"><input type="submit"  value="加入购物车" id="input"></td>
		</tr>
	</table>
	
</form>
</body>
</html>