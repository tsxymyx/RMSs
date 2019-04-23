package com.chinasofti.hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.synth.SynthStyle;

import org.junit.Test;

import com.chinasofti.hotel.dao.CardDao;
import com.chinasofti.hotel.dao.CartDao;
import com.chinasofti.hotel.dao.EmployeeDao;
import com.chinasofti.hotel.dao.FoodDao;
import com.chinasofti.hotel.dao.MenuDao;
import com.chinasofti.hotel.dao.OrderitemDao;
import com.chinasofti.hotel.dao.OrdersDao;
import com.chinasofti.hotel.dao.UsersDao;
import com.chinasofti.hotel.dao.impl.CardDaoImpl;
import com.chinasofti.hotel.dao.impl.CartDaoImpl;
import com.chinasofti.hotel.dao.impl.EmployeeDaoImpl;
import com.chinasofti.hotel.dao.impl.FoodDaoImpl;
import com.chinasofti.hotel.dao.impl.MenuDaoImpl;
import com.chinasofti.hotel.dao.impl.OrderitemDaoImpl;
import com.chinasofti.hotel.dao.impl.OrdersDaoImpl;
import com.chinasofti.hotel.dao.impl.UsersDaoImpl;
import com.chinasofti.hotel.domain.Card;
import com.chinasofti.hotel.domain.Cart;
import com.chinasofti.hotel.domain.Employee;
import com.chinasofti.hotel.domain.Food;
import com.chinasofti.hotel.domain.Menu;
import com.chinasofti.hotel.domain.Orderitem;
import com.chinasofti.hotel.domain.Orders;
import com.chinasofti.hotel.domain.Users;

public class DaoTest {

	@Test
	public void addCart(){
		Menu m=new Menu(8, "yy");
		//Food f=new Food(109, m, "四喜丸子", 60, "y");
		CartDao c=new CartDaoImpl();
		//System.out.println(c.addCart(new Cart(f,2)));
		c.addCart(new Cart(new Food(102,new Menu(1,"肉菜"),"鱼香肉丝",30,"y"),2));
	}
	@Test
	public void deleteCartById(){
		CartDao c=new CartDaoImpl();
		c.deleteCartById(109);
	}
	
	@Test
	public void selectAllCart(){
		CartDao c=new CartDaoImpl();
		List<Cart> list = c.selectAllCart();
		System.out.println(list.size());
		for (Cart cart : list) {
			System.out.println(cart);
		}
	}
	@Test
	public void selectCardById(){
		CardDao c=new CardDaoImpl();
		System.out.println(c.selectCardById(100002));
		//c.selectCardById(2);
		
	}
	@Test
	public void updateCard(){
		CardDao c=new CardDaoImpl();
		Users u=new Users(5, "周七","55555555555" ,null);
		c.updateCard(new Card(100002,u,550,550.50,0.9,0));		
	}
	@Test
	public void addCard(){
		CardDao c=new CardDaoImpl();
		String dStr ="1998-12-12";    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d;
		try {
			d = sdf.parse(dStr);
			System.out.println(d);
			Users u=new Users(5, "周七","55555555555" ,d);
			c.addCard(new Card(5, u, 10, 100, 0.9, 0));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void selectAllCard(){
		CardDao c=new CardDaoImpl();
		List<Card> list = c.selectAllCard();
		System.out.println(list.size());
		for (Card card : list) {
			System.out.println(card);
		}
	}
	
	@Test 
	public void login(){
		EmployeeDao e=new EmployeeDaoImpl();
		e.loginEmployee("222"," 222");
	}
	@Test
	public void addEmployee(){
		EmployeeDao e=new EmployeeDaoImpl();
		e.addEmployee(new Employee(1009,"经理2","222","222",1));
	}
	@Test
	public void deleteEmployeeById(){
		EmployeeDao e=new EmployeeDaoImpl();
		e.deleteEmployeeById(1009);
	}
	
	@Test
	public void updateEmployee(){
		EmployeeDao e=new EmployeeDaoImpl();
		e.updateEmployee(new Employee(1005,"经理1","222","222",1));
	}
	
	@Test
	public void selectAllEmployee(){
		EmployeeDao e=new EmployeeDaoImpl();
		List<Employee> list=e.selectAllEmployee();
		for (Employee em : list) {
			System.out.println(em);
		}
	}
	
	@Test
	public void selectEmployeeById(){
		EmployeeDao e=new EmployeeDaoImpl();
		System.out.println(e.selectEmployeeById(1006));
	}
	@Test
	public void selectAllFood(){
		FoodDao f=new FoodDaoImpl();
		List<Food> list = f.selectAllFood();
		System.out.println(list.size());
		for (Food fo : list) {
			System.out.println(fo);
		}
	}
	@Test
	public void selectFoodById(){
		FoodDao f=new FoodDaoImpl();
		System.out.println(f.selectFoodById(107));
		
	}
	@Test
	public void addFood(){
		FoodDao f=new FoodDaoImpl();  
		Menu m=new Menu(7,"饮料");
		f.addFood(new Food(1,m,"小鸡炖蘑菇汤",20.00,"n"));	
		
	}
	
	@Test
	public void delectFoodById(){
		FoodDao f=new FoodDaoImpl();  
		f.delectFoodById(1)	;
		
	}
	
	@Test
	public void updateFood(){
		FoodDao f=new FoodDaoImpl();  
		Menu m=new Menu(7,"饮料");
		f.updateFood(new Food(102,m,"宫保鸡丁",20,"y"));		
	}
	
	@Test
	public void addMenu(){
		MenuDao m=new MenuDaoImpl();
		m.addMenu(new Menu(7,"饮品"));
	}
	@Test
	public void deleteMenuById(){
		MenuDao m=new MenuDaoImpl();
		m.delectMenuById(7);
	}
	
	@Test
	public void selectAllOrders(){
		OrdersDao o=new OrdersDaoImpl();
		List<Orders> list = o.selectAllOrders();
		for (Orders or : list) {
			System.out.println(or);
		}
	}
	@Test
	public void selectOrdersById(){
		OrdersDao o=new OrdersDaoImpl();	
		System.out.println(o.selectOrdersById(222222));
	}
	@Test
	public void addOrders() throws ParseException{
		OrdersDao o=new OrdersDaoImpl();	
		String dStr ="1997-03-24";    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date utilDate = sdf.parse(dStr);
		    //System.out.println(utilDate);//查看utilDate的值
		    Date date = new java.sql.Date(utilDate.getTime());
		    //System.out.println(date);//查看date的值
		Employee e=new Employee(1005,"经理1","222","222",1);
		//Users u=new Users(5, "周七","55555555555" ,date);
		Card c=new Card(5, null, 10, 100, 0.9, 0);
		o.addOrders(new Orders("555555", e, c, date, 250));
		
	}
	@Test
	public void selectCartById(){
		CartDao c=new CartDaoImpl();
		System.out.println(c.selectCartById(102));
	}
	
	@Test
	public void deleteCart(){
		CartDao c=new CartDaoImpl();
		c.clearCart();
	}
	@Test
	public void selectUsersById(){
		UsersDao u=new UsersDaoImpl();
		System.out.println(u.selectUsersById(1));
	}
	@Test
	public void addUsers(){
		UsersDao u=new UsersDaoImpl();
		String dStr ="1998-12-12";    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d;
		try {
			d = sdf.parse(dStr);
			u.addUsers(new Users(6, "李思思", "66666666666", d));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void selectAllUsers(){
		UsersDao u=new UsersDaoImpl();
		List<Users> list = u.selectAllUsers();
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	@Test
	public void selectFoodByName(){
		FoodDao f=new FoodDaoImpl();
		System.out.println(f.selectFoodByName("宫保鸡丁"));
		
	}
	
	@Test
	public void selectCardByName(){
		CardDao c=new CardDaoImpl();
		System.out.println(c.selectCardByName("李四"));
	}
	
	@Test
	public void selectAllMenu(){
		MenuDao m=new MenuDaoImpl();
		List<Menu> list = m.selectAllMenu();
		for (Menu menu : list) {
			System.out.println(menu);
		}
	}
	
	@Test
	public void selectAllOrderitem(){
		OrderitemDao o=new OrderitemDaoImpl();
		List<Orderitem> list = o.selectAllOrderitem();
		for (Orderitem orderitem : list) {
			System.out.println(orderitem);
		}
	}
	@Test
	public void selectOrderitemById(){
		OrderitemDao o=new OrderitemDaoImpl();
		System.out.println(o.selectOrderitemById("333333"));
	}
	@Test
	public void addOrderitem(){
		OrderitemDao o=new OrderitemDaoImpl();
		String dStr ="1997-03-24";    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date utilDate;
			try {
				utilDate = sdf.parse(dStr);
				 //System.out.println(utilDate);//查看utilDate的值
			    Date date = new java.sql.Date(utilDate.getTime());
			    //System.out.println(date);//查看date的值
			Orders o1 = new Orders("555555", null, null, date, 250);
			
			Food f1 = new Food(102,null,"宫保鸡丁",20,"y");
			o.addOrderitem(new Orderitem(o1, f1, 2));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	}
	
}
