package com.revature.bookproject.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.bookproject.model.Books;
import com.revature.bookproject.model.Order;
import com.revature.bookproject.model.OrderDetails;
import com.revature.bookproject.model.OrderedBook;
import com.revature.bookproject.model.User;
import com.revature.bookproject.repository.BookJpaRepository;
import com.revature.bookproject.repository.OrderDetailsJpaRepository;
import com.revature.bookproject.repository.OrderJpaRepository;
import com.revature.bookproject.repository.UserJpaRepository;

@Service
public class OrderServices {
	@Autowired
	private  OrderJpaRepository orderJpaRepository;
	@Autowired
	private  OrderDetailsJpaRepository orderDetailsJpaRepository;
	@Autowired
	private  BookJpaRepository bookJpaRepository;
	@Autowired
	private  UserJpaRepository userJpaRepository;
	
	public String insertOrder(Order o)
	{
		orderJpaRepository.save(o);
		return "Ordered taken for "+o.getOrderId();
	}
	public String registerOrder(long bid1[],int uid)
	{
		Books[] b=new Books[bid1.length];
		User u=userJpaRepository.findById(uid).orElse(null);
		for(int i=0;i<bid1.length;i++)
		{
			b[i]=bookJpaRepository.findById(bid1[i]).orElse(null);
		}
		Order order=new Order(new Date(),"booked",u);
		Order o=orderJpaRepository.save(order);
		return o.getOrderId()+" is taken";
	}
	
	public int insertOrderBook(OrderedBook o)
	{
		List<Long> list=o.getBookid();
		System.out.println(list);
		int len=list.size();
		System.out.println("Size:"+len);
		long quantity[]=new long[len/2];
		Books[] b=new Books[len/2];
		List<OrderDetails> ol=new ArrayList<OrderDetails>();
		OrderDetails[] ob=new OrderDetails[len/2];
		//Order order=null;
		User u=userJpaRepository.findById(o.getUid()).orElse(null);
		//Order order=new Order(new Date(),"ordered",u);
		System.out.println("hii");
		int j=0;
		for(int i=0;i<len;i=i+2)
		{
			b[j]=bookJpaRepository.findById(list.get(i)).orElse(null);
			quantity[j]=list.get(i+1);
			j++;
			System.out.println("lakshmi");
			
		}	
		Order order=new Order(new Date(),"ordered",u);
		double p=0.0;
		for(int i=0;i<len/2;i++)
		{
			p=(double)b[i].getBookPrice()*(double)quantity[i];
			ob[i]=new OrderDetails(b[i],order,quantity[i],p);
			ol.add(ob[i]);
			b[i].addOrderDetail(ob[i]);
			orderDetailsJpaRepository.save(ob[i]);
			System.out.println("priya");
		}

		order.addOrderDetail(ol);
		orderJpaRepository.save(order);
		return order.getOrderId();
	}

}
