<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="dataGrid.js"></script>
<script type="text/javascript">
$(function(){	
	$("#itemstable").dataGrid({url:"ShowcartServlet"});
})
</script>
<title>查看购物车</title>
</head>
<body>
<form action="ShopCartClear?confirm=pay" method="post">
<table align=center border=1  id="itemstable"style="display:table;">
	<caption><h2>您在购物车中加入了如下商品</h2></caption>
	<tr>
		<td field="pname">商品名称</td>
		<td field="pmadew">产地</td>
		<td field="pcomp">生产公司</td>
		<td field="description">描述</td>
		<td field="realprice">购买价格</td>
		<td field="amount">购买数量</td>
		<td field="totalReal">小结</td>
	</tr>
</table>
<table align=center  style="display:table;" id="compare">
<tr align=left>
		<td colspan=8>本次购物您<strong>本来</strong>需要花费<strong id="real">0</strong>元，在本站购买需要<strong id="cut"></strong>元</td>
	</tr>
	<tr>
		<td colspan=8>本站为您节省了<strong id="multi"></strong>元</td>
	</tr>
	<tr>
		<td colspan=3><a href="add.jsp"><strong>继续购买</strong></a></td>
		<td colspan=3><a href="list.jsp"><strong>返回商品列表</strong></a></td>
		<td colspan=3><a href="/ShopOnLine/ShopCartClear?confirm=clear"><strong>清空购物车</strong></a></td>
	</tr>
	<tr>
		<td colspan=8 align=center><input type="submit" value="结&nbsp&nbsp&nbsp&nbsp算" style="background-color: red;width: 330px;"></td>
	</tr>
</table>
</form>
</body>
</html>