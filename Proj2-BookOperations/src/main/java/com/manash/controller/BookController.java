package com.manash.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manash.command.BookCommand;
import com.manash.msg.ProjMsg;

@Controller
public class BookController {
	
	public static Map<Integer,Object> bookMap=null;
	public static List bookList=null;
	public BookController() {
		bookMap=new HashMap<Integer,Object>();
		bookList=new ArrayList<>();
	}
	
	@Autowired
	private ProjMsg msg;
	
	@RequestMapping(value="/bookPage")
	public String bookHomePage(Map<String,Object> map) {
		//create command class object
		BookCommand book=new BookCommand();
		map.put("book", book);
		return "book_page";
	}
	
	/*@RequestMapping(value="/bookPage",method=RequestMethod.POST)
	public String saveBook(Map<String,Object> map,@ModelAttribute("book")BookCommand command) {
		System.out.println("***saveBook Method***");
		//add book object into map collection
		bookMap.put(command.getBookId(),command);
		map.put("bookList",bookMap);
		map.put("book", new BookCommand());
		map.put("msg", "Book Details Added Succesfully");
		return "book_page";
	}*/
	@RequestMapping(value="/bookPage",method=RequestMethod.POST)
	public String saveBook(Model model,@ModelAttribute("book")BookCommand command) {
		System.out.println("***saveBook Method***");
		//add book object into map collection
		bookMap.put(command.getBookId(),command);
		model.addAttribute("bookList",bookMap);
		model.addAttribute("msg", "Book Details Added Succesfully");
		BookCommand cmd=new BookCommand();
		model.addAttribute("book",cmd);
		return "book_page";
	}
	
	/*@ModelAttribute("book")
	public BookCommand createBookObj() {
		return new BookCommand();
	}*/
	
	@RequestMapping(value="/bookPage",method=RequestMethod.GET)
	public String editBook(Map<String,Object> map,@ModelAttribute("book")BookCommand command,HttpServletRequest req) {
		int id=0;
		//get id value from request
		id=Integer.parseInt(req.getParameter("id"));
		
		return "book_page";
	}
}
