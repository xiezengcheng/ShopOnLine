package cn.ac.ict.ShopOnLine.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import cn.ac.ict.ShopOnLine.model.Product;
import cn.ac.ict.ShopOnLine.model.ShoppingCart;
import cn.ac.ict.ShopOnLine.model.ShoppingItem;

public class ShowcartService {
	
	public String getProductFromCart(Collection<ShoppingItem> Itemslist, float totalReal, float totalCut) {
		
		Iterator<ShoppingItem> it = Itemslist.iterator();
		ArrayList<ShoppingItem> list = new ArrayList<>();
		while(it.hasNext()) {
			ShoppingItem item = it.next();
			list.add(item);
		}
		String proJson = "{\"data\":";
		proJson += list.toString();
		proJson+=",\"totalReal\":"+totalReal+",\"totalCut\":"+totalCut+"}";
		return proJson;
	}
	
}
