package cn.ac.ict.ShopOnLine.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * 模拟一个购物车
 * 保存了所有商品项目的信息
 * 
 * @author 谢增程
 *
 */
public class ShoppingCart{

	private HashMap<Integer,ShoppingItem> items;
	private int itemAmount;
	
	public ShoppingCart() {
		items = new HashMap<>();
		itemAmount = 0;
	}
	
	/**
	 * 向购物车中添加一个商品项目
	 */
	public synchronized void add(Integer pid,Product product,int num) {
		if(items.containsKey(pid)) {
			ShoppingItem newitem = items.remove(pid);
			Integer amount = (int)newitem.getAmount()+num;
			ShoppingItem item = new ShoppingItem(product,amount);
			items.put(pid,item);
		}else {
			ShoppingItem newitem = new ShoppingItem(product, num);
			items.put(pid, newitem);
			itemAmount++;
		}
	}
	
	/**
	 * 从购物车中移除指定的商品项目
	 */
	public synchronized void remove(String pid) {
		if(items.containsKey(pid)) {
			items.remove(pid);
			itemAmount--;
		}
	}
	
	/**
	 * 获取购物车中的所有商品项目
	 */
	public synchronized Collection<ShoppingItem> getItems() {
		return items.values();
	}
	protected void finalize() {
		items.clear();
	}
	
	//获取当前购物车商品项目的数目
	public synchronized int getItemAmount() {
		return itemAmount;
	}
	
	public synchronized float getTotalReal() {
		float total = 0.0f;
		Iterator<ShoppingItem> it = getItems().iterator();
		while(it.hasNext()) {
			ShoppingItem si = it.next();
			Product product = si.getItem();
			total += product.getRealprice()*si.getAmount();
		}
		return total;
	}
	
	//计算购物车中在本站购物所需要的所有花费之和
	public synchronized float getTotalCut() {
		float total = 0.0f;
		Iterator<ShoppingItem> it = getItems().iterator();
		while(it.hasNext()) {
			ShoppingItem si = it.next();
			Product product = si.getItem();
			total += product.getCutprice()*si.getAmount();
		}
		return total;
	}
	
	public void clear() {
		items.clear();
		itemAmount=0;
	}
	
}
