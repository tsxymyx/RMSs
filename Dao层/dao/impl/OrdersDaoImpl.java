package com.chinasofti.hotel.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chinasofti.hotel.dao.OrdersDao;
import com.chinasofti.hotel.domain.Card;
import com.chinasofti.hotel.domain.Employee;
import com.chinasofti.hotel.domain.Orders;
import com.chinasofti.hotel.util.DBUtil;

public class OrdersDaoImpl implements OrdersDao {
	private DBUtil db;
	public List<Orders> selectAllOrders() {
		this.db=new DBUtil();
		List<Orders> list=new ArrayList<Orders>();
		String sql="select o.*,c.*,e.* from orders o,card c,employee e where o.cno=c.cno(+) and o.empId=e.empId";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				list.add(new Orders(rs.getInt("oid"),
						new Employee(rs.getInt("empId"),
								rs.getString("eName"),
								rs.getString("empAccount"),
								rs.getString("empPassword"),
								rs.getInt("pow")),
						new Card(rs.getInt("cno"),
								null,
								rs.getInt("score"),
								rs.getDouble("money"),
								rs.getDouble("discount"),
								rs.getInt("status")),
						rs.getDate("oDate"),
						rs.getDouble("total")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.db.closed();
		}
		return null;
	}
	public Orders selectOrdersById(int id) {
		this.db=new DBUtil();
		String sql="select o.*,c.*,e.* from orders o,card c,employee e where o.cno=c.cno(+) and o.empId=e.empId and oid="+id;
		Orders o=new Orders();
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				o.setOid(rs.getInt("oid"));
				o.setE1(new Employee(rs.getInt("empId"),
						rs.getString("eName"),
						rs.getString("empAccount"),
						rs.getString("empPassword"),
						rs.getInt("pow")));
				o.setC1(new Card(rs.getInt("cno"),
						null,
						rs.getInt("score"),
						rs.getDouble("money"),
						rs.getDouble("discount"),
						rs.getInt("status")));
				o.setOdate(rs.getDate("oDate"));
				o.setTotal(rs.getDouble("total"));	
				return o;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.db.closed();
		}
		return null;
	}
	

	public boolean addOrders(Orders o) {
		this.db=new DBUtil();
		String sql="insert into orders values(?,?,?,?,?)"; 
          java.sql.Date da = new java.sql.Date(o.getOdate().getTime());
		try {
			
			int i = this.db.update(sql, o.getOid(),o.getE1().getEmpId(),o.getC1().getCno(),da,o.getTotal());
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
