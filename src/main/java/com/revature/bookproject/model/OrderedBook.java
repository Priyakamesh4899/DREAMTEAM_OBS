package com.revature.bookproject.model;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderedBook {
	private List<Long> bookid;
	private int uid;
	public List<Long> getBookid() {
		return bookid;
	}
	public void setBookid(List<Long> bookid) {
		this.bookid = bookid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public OrderedBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderedBook(List<Long> bookid, int uid) {
		super();
		this.bookid = bookid;
		this.uid = uid;
	}
	
	
	
	
}
