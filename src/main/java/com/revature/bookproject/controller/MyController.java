package com.revature.bookproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.bookproject.model.Books;

import com.revature.bookproject.services.BookServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/controller")
public class MyController {
	@Autowired
	private  BookServices services;
	
	
	/*@GetMapping(value="/employees/{id}")
	public Optional<Employee> displayByEmpID(@PathVariable int id){
		return empJpaRepository.findById(id);
	}
	
	@GetMapping(value="/show")
	public List<Employee> displayAll(){
		return empJpaRepository.findAll();
		
	}*/
	@GetMapping(value="/displayAll")
	public List<Books> display(){
		return services.displayBooks();
		
	}
	
	
	@GetMapping(value="/displayPat/{pattern}")
	public List<Books> displayByPattern(@PathVariable String pattern){
		System.out.println(pattern);
		return services.displayBooksPattern(pattern);
		
	}
	
	
	@GetMapping(value="/displayAsc")
	public List<Books> displayInAplbhetical(){
		return services.sortBooks();
		
	}
	
	@GetMapping(value="/books/bname/{name}")
	public Books displayName(@PathVariable String name){
		return services.displayBookByName(name);                 //bookJpaRepository.findByName(b.getBookName())
		
	}
	
	
	@PostMapping(value="/insert")
	public String insertBook(@RequestBody Books b){
		return services.saveBook(b);
		
	}
	
	
	
	
	
	
	
	@GetMapping(value="/books/{id}")
	public Books showId(@PathVariable(value="id") Long id){
		return services.displayBookById(id);                
		
	}
	
	@GetMapping(value="/books/author/{name}")
	public List<Books> displayBookName(@PathVariable String name){
		
		return services.displayBooksByAuthorName(name);//bookJpaRepository.findByName(b.getBookName())
		
	}
	
	@PutMapping(value="/stock/{id}/{quantity}")
	public Books updateStockDec(@PathVariable(value="id") Long id,@PathVariable(value="quantity") int quantity)
	{
		return services.reduceStock(id,quantity);
	}
	@PutMapping(value="/add/stock/{id}/{quantity}")
	public Books updateStockInc(@PathVariable(value="id") Long id,@PathVariable(value="quantity") int quantity)
	{
		return services.addStock(id,quantity);
	}
	
	
	@DeleteMapping(value="books/delete/{id}")
	public String deleteBook(@PathVariable Long id)
	{
		 return services.deleteBookById(id);
		
	}
	


}
