package cn.ac.ict.ShopOnLine.utils;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;
import javax.sql.DataSource;
public class DBPool implements DataSource{
	private LinkedList<Connection> pool = new LinkedList<>();
	public DBPool() {
		try {
			Properties properties = new Properties();
			InputStream is = DBPool.class.getClassLoader().getResourceAsStream("jdbc.properties");
			properties.load(is);
			String driver = properties.getProperty("DRIVER");
			String url = properties.getProperty("URL");
			String user = properties.getProperty("USER");
			String password = properties.getProperty("PASSWORD");
			Class.forName(driver);
			for(int i =0;i<3;i++) {
				final Connection connection = DriverManager.getConnection(url, user, password);
				Object proxyObject = Proxy.newProxyInstance(DBPool.class.getClassLoader(), new Class[] {Connection.class}, new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						if(method.getName().equals("close")) {
							synchronized (pool) {
								pool.add((Connection)proxy);
								pool.notify();
							}
							return null;
						}else {
							return method.invoke(connection,args);
						}
					}
				});
				pool.add((Connection)proxyObject);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		synchronized(pool) {
			if(pool.size()==0) {
				try {
					pool.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return getConnection();
			}
		}
		
		return pool.removeFirst();
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
