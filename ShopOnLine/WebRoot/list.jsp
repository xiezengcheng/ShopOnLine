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
	$("table").dataGrid({url:"ProductServlet"});
})
</script>
<title>产品列表</title>
</head>
<body>
	<table align=center border=1>
	<caption><h2>您可购买的商品列表</h2></caption>
		<tr>
			<td field="pname">商品名称</td>
			<td field="pmadew">产地</td>
			<td field="pcomp">生产公司</td>
			<td field="realprice">实际价格</td>
			<td field="cutprice">优惠价</td>
			<td field="description">描述</td>
			<td field="pid" format="urlFormat">购买</td>
		</tr>
	</table>
	<a href="showcart.jsp"><h3 align="center">查看购物车</h3></a>
	
</body>
</html>