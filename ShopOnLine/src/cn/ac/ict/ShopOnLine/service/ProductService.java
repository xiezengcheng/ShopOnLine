package cn.ac.ict.ShopOnLine.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import cn.ac.ict.ShopOnLine.Dao.ProductDao;
import cn.ac.ict.ShopOnLine.model.Product;

public class ProductService {
	private ProductDao proDao;
	
	public ProductService() {
		proDao = new ProductDao();
	}
	
	//获取所有商品并保存在JSON格式字符串中
	public String getAllProduct() {
		ArrayList<Product> proList = new ArrayList<>();
		try {
			proList = proDao.getAllProductFromDB();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		String proJson = "{\"data\":";
		proJson += proList.toString();
		proJson+="}";
//		System.out.println(proJson);
		return proJson;	
	}

	//根据id获取一个商品的所有信息
	public Product getProductById(String pid) {
		try {
			return proDao.getProductByIdFromDB(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage(),e);
		}
	}
}
