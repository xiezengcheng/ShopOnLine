package cn.ac.ict.ShopOnLine.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.ac.ict.ShopOnLine.model.Product;
import cn.ac.ict.ShopOnLine.utils.DBPool;


public class ProductDao {
	
	private DBPool pool;
	private Connection conn;
	
	//构造函数 同时创建一个连接池
	public ProductDao() {
		pool = new DBPool();
		try {
			conn  = pool.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	
	/**
	 * 从数据库中获取所有商品信息
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Product> getAllProductFromDB() throws SQLException {
			Statement statement = conn.createStatement();
			String sql = "select * from productlist";
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<Product> list = new ArrayList<>();
			while(rs.next()) {
				Product pro = new Product(rs.getString("pid"),rs.getString("pname")
						,rs.getString("pcomp"),rs.getString("madew"),rs.getDate("madedate")
						,rs.getFloat("rprice"),rs.getFloat("cprice"),rs.getInt("count"),rs.getString("description"));
			
				list.add(pro);
			}
			return list;
	}
	
	/**
	 * 
	 * 根据商品的id从数据库中获取商品信息
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
	public Product getProductByIdFromDB(String pid) throws SQLException {
		String sql = "select * from productlist where pid =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, pid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		Product pro = new Product(rs.getString("pid"),rs.getString("pname")
				,rs.getString("pcomp"),rs.getString("madew"),rs.getDate("madedate")
				,rs.getFloat("rprice"),rs.getFloat("cprice"),rs.getInt("count"),rs.getString("description"));	
		return pro;
	}
}
