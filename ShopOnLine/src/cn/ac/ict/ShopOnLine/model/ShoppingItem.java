package cn.ac.ict.ShopOnLine.model;

/**
 * 
 * 表示一个购买项目 封装了商品的信息和商品的数量信息
 * 
 * @author 谢增程
 *
 */

public class ShoppingItem {
	private Product item;
	private int amount = 0;

	public ShoppingItem(Product product, int num) {
		if (num > 0) {
			item = product;
			amount = num;
		}
	}

	public void InAmoutn() {
		amount++;
	}

	public void DeAmount() {
		amount--;
	}

	public Product getItem() {
		// TODO Auto-generated method stub
		return item;
	}

	public float getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

	@Override
	public String toString() {
		return "{" + "\"pid\"" + ":" + "\"" + getItem().getPid() + "\"" + ",\"pname\":" + "\"" + getItem().getPname()
				+ "\"" + ",\"pcomp\":" + "\"" + getItem().getPcomp() + "\"" + ",\"pmadew\":" + "\""
				+ getItem().getPmadew() + "\"" + ",\"realprice\":" + "\"" + getItem().getRealprice() + "\""
				+ ",\"cutprice\":" + "\"" + getItem().getCutprice() + "\"" + ",\"amount\":" + "\"" + getAmount() + "\""
				+ ",\"description\":" + "\"" + getItem().getDescription() + "\"" 
				+ ",\"totalReal\":" + "\"" + getAmount()*(getItem().getRealprice()) + "\"" + "}";
	}
}
