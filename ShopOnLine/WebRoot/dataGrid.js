/**
 * 
 */
	//根据format属性的值自定义实现方法
	//将pid传过来追加到url中
	function urlFormat(pid){
		//console.log(pid);
		return "<a href='/ShopOnLine/Putintocart?add="+pid+"'"+">加入购物车</a>";
	}
	
	//data为获得的数据,element为table元素(jquery元素)
	function autoCreateTable(data,element){
		//拿到所有td
		var tds = element.find("td");
		//遍历data中的元素
		for(var i = 0;i<data.length;i++){
			//拿到data中某一个数据
			var rowData = data[i];
			//创建一个行
			var tr = $("<tr>");
			//遍历tds
			for(var j=0;j<tds.length;j++){
				var td1 = $(tds[j]);//转化为jquery元素
				//console.log(td);
				//拿到field属性值
				var field = td1.attr("field");
				if(rowData[field]==null){
					rowData[field]="";
				}
				var td2 = null;
				//拿到format属性值
				var format = td1.attr("format");
				if(format){
					//根据format自己实现相应的方法
					var td2 = $("<td>"+window[format](rowData[field])+"</td>");
				}else{
					var td2 = $("<td>"+rowData[field]+"</td>"); 
				}
				tr.append(td2);
			}
			
			//把tr加到table上
			element.append(tr);		
		}
	}

	function InsertData(totalReal,totalCut){
		console.log(totalCut);
		$("#real").html(totalReal);
		$("#cut").html(totalCut);
		var multi = parseInt(totalReal)-parseInt(totalCut);
		$("#multi").html(multi);
	}
	
	function loadData(url,element){
		//get方式发送请求
		$.get(url,function(rs){
			var result = JSON.parse(rs);
			//console.log(result);
			autoCreateTable(result.data,element);
			if(result.totalReal&&result.totalCut){
				InsertData(result.totalReal,result.totalCut);
			}
		});
		
	}
	//扩展一个dataGrid方法
	$.fn.dataGrid = function(options){
		
		this.each(function(i,element){
			//element为table dom对象

			loadData(options.url,$(element));
		});
		
	}