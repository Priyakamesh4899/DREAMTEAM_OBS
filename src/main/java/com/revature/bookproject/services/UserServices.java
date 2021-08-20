package com.revature.bookproject.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.bookproject.model.User;
import com.revature.bookproject.repository.UserJpaRepository;

@Service
public class UserServices {
	@Autowired 
private  UserJpaRepository userJpaRepository;
	
	
	/*public String saveBook(Books b)
	{
		bookJpaRepository.save(b);
		return "Inserted"+b.getBookName();
	}

	
	public List<Books> displayBooks()
	{
		return bookJpaRepository.findAll();
	}
	
	public Books displayBookByName(String name)
	{
		return bookJpaRepository.findByBookName(name);
	}

	
	public List<Books> displayBooksByAuthorName(String author)
	{
	   List<Books> list=  bookJpaRepository.findAllByAuthorName(author);  
	   return list;
	}
	
	public Books displayBookById(Long id)
	{
		return bookJpaRepository.findById(id).orElse(null);
		
	}
	
	public Books reduceStock(Long id,int quantity)
	{
		//Books book=displayBookById(id);
		 Books existingProduct = bookJpaRepository.findById(id).orElse(null);
	        existingProduct.setStock( existingProduct.getStock()-quantity);
	       
	        return bookJpaRepository.save(existingProduct);
	}*/
	
	public String addUser(User u)
	{
		userJpaRepository.save(u);
		return "Hi "+u.getUserName() +" ,you have been registered in our book store successfully";
	}
	
	
	/*public String deleteBookById(Long id)
	{
		 bookJpaRepository.deleteById(id);
		 return "Book id"+id+" is removed";
	}*/
	

}
