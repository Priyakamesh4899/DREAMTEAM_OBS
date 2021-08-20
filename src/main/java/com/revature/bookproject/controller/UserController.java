package com.revature.bookproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.bookproject.model.Order;
import com.revature.bookproject.model.OrderedBook;
import com.revature.bookproject.model.User;
import com.revature.bookproject.services.OrderServices;
import com.revature.bookproject.services.UserServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ucontroller")
public class UserController {
	@Autowired
	private UserServices uservice;
	
	
	@Autowired
	private OrderServices oservice;
	
	
	@PostMapping(value="/register")
	public String insertUser(@RequestBody User u){
		return uservice.addUser(u);
		
	}
	
	@PostMapping(value="/addingOrder")
	public int takeOrder(@RequestBody OrderedBook ob){
		
		return oservice.insertOrderBook(ob);
		
	}
	
	@PostMapping(value="/addOrder")
	public String takeOrders(@RequestBody Order o){
		
		return oservice.insertOrder(o);
		
	}
	
	@PostMapping(value="/addOrders")
	public String takeOrders1(long[] bid1,int uid){
		return null;
		
		//return oservice.registerOrder(bid1,uid);
		
		
	}
	
	
	

}
