package com.chinasofti.hotel.dao.impl;

import java.sql.SQLException;

import com.chinasofti.hotel.dao.MenuDao;
import com.chinasofti.hotel.domain.Menu;
import com.chinasofti.hotel.util.DBUtil;

public class MenuDaoImpl implements MenuDao {
	private DBUtil db;
	public boolean addMenu(Menu m) {
		this.db=new DBUtil();
		String sql="insert into menu values(?,?)";
		try {
			int i = this.db.update(sql, m.getMenuId(),m.getMenuName());
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			this.db.closed();
		}
		
	}

	public boolean delectMenuById(int id) {
		this.db=new DBUtil();
		String sql="delete from menu where menuId="+id;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			this.db.closed();
		}	
	}

}
