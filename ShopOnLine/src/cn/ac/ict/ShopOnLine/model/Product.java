package cn.ac.ict.ShopOnLine.model;

import java.util.Date;

/**
 * 用于保存商品的基本信息
 * 如：名称、价格、生产厂家等信息
 * 
 * 
 * @author 谢增程
 *
 */
public class Product {
	//下面是商品的基本属性
	private String pid;//商品id
	private String pname;//商品名称
	private String pcomp;//商品厂家
	private String pmadew;//商品产地
	private Date pmadeyear;//商品生产日期
	private float realprice;//商品实际价格
	private float cutprice;//商品优惠价格
	private int amount;//商品总数
	private String description;//商品描述信息
	
	public Product() {
		
	}
	
	public Product(String pid, String pname, String pcomp, String pmadew, Date pmadeyear, float realprice,
			float cutprice, int amount, String description) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcomp = pcomp;
		this.pmadew = pmadew;
		this.pmadeyear = pmadeyear;
		this.realprice = realprice;
		this.cutprice = cutprice;
		this.amount = amount;
		this.description = description;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcomp() {
		return pcomp;
	}
	public void setPcomp(String pcomp) {
		this.pcomp = pcomp;
	}
	public String getPmadew() {
		return pmadew;
	}
	public void setPmadew(String pmadew) {
		this.pmadew = pmadew;
	}
	public Date getPmadeyear() {
		return pmadeyear;
	}
	public void setPmadeyear(Date pmadeyear) {
		this.pmadeyear = pmadeyear;
	}
	public float getRealprice() {
		return realprice;
	}
	public void setRealprice(float realprice) {
		this.realprice = realprice;
	}
	public float getCutprice() {
		return cutprice;
	}
	public void setCutprice(float cutprice) {
		this.cutprice = cutprice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "{"+"\"pid\""+":"+"\""+pid+"\""+",\"pname\":"+"\""+pname+"\""+",\"pcomp\":"+"\""+pcomp+"\""+",\"pmadew\":"+"\""+pmadew+"\""+",\"realprice\":"+"\""+realprice+"\""+",\"cutprice\":"+"\""+cutprice+"\""+",\"amount\":"+"\""+amount
				+"\""+",\"description\":"+"\""+description+"\""+"}";
	}
	
	
}
