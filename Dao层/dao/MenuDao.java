package com.chinasofti.hotel.dao;

import com.chinasofti.hotel.domain.Menu;

public interface MenuDao {
	//增加菜品
	public boolean addMenu(Menu m);
	//删除菜品
	public boolean delectMenuById(int id);
}
