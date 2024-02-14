package com.nama.springboot.firstdemo.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.nama.springboot.firstdemo.dao.BookDao;
import com.nama.springboot.firstdemo.model.Book;
import com.nama.springboot.firstdemo.model.Student;

@Controller
public class BookController {
	
	@Autowired
	BookDao bookdao;
	
	    
	@GetMapping("mybook/{bookid}")
	public String getBookDetails(@PathVariable int bookid,ModelMap model)
	{
		
		System.out.println("inside getbookdetails..");
		
		Book b = bookdao.getBook(bookid);
		
		if(b!=null)
		  model.addAttribute("mybook",b);
		else
		  model.addAttribute("msg","book with bookid:"+bookid+"not found!");
		
          return "book";
		
	}
	
}