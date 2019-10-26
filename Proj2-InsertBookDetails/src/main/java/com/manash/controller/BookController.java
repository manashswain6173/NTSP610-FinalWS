package com.manash.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manash.command.BookCommand;
import com.manash.dto.BookDTO;
import com.manash.entity.BookDetails;
import com.manash.msg.AppsMsg;
import com.manash.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	@Autowired
	private AppsMsg appmsg;
	
	/**
	 * This Method Lunches the initial form page
	 * @param model
	 * @return String
	 */
	@RequestMapping(value="/bookPage",method=RequestMethod.GET)
	public String showForm(Model model) {
		//create command class object to pass some additional data to form page
		BookCommand bookCmd=new BookCommand();
		//add command object into model attribute
		model.addAttribute("book",bookCmd);
		return "book_page";
	}
	
	/**
	 * This Method Process the form submission
	 * @param model
	 * @param cmd
	 * @return String
	 */
	@RequestMapping(value="bookPage",method=RequestMethod.POST)
	public String submitForm(Model model,@ModelAttribute("book")BookCommand cmd) {
		List<BookDetails> bookList=null;
		BookDetails savedBook=null;
		String msg=null;
		//create dto class object
		BookDTO dto=new BookDTO();
		//copy properties from command to dto 
		BeanUtils.copyProperties(cmd, dto);
		//invoke service class method to perform business logics
		savedBook=service.saveBook(dto);
		//get all book details 
		bookList=service.getAllBook();
		//add book object to model attribute
		model.addAttribute("bookList", bookList);
		msg=(savedBook!=null)?appmsg.appsMsg.get("succMsg"):appmsg.appsMsg.get("failMsg");
		model.addAttribute("msg1", msg);
		//set empty command object to model attribute to empty the form page
		model.addAttribute("book", new BookCommand());
		return "book_page";
	}
	/**
	 * This Method Performs book remove operation
	 * @param model
	 * @param req
	 * @return String
	 */
	@RequestMapping(value="/deleteBook",method=RequestMethod.GET)
	public String deleteBook(Model model,HttpServletRequest req) {
		Integer id=0;
		List<BookDetails> bookList=null;
		//read append query param 
		id=Integer.parseInt(req.getParameter("id"));
		//remove book by id
		service.removeBook(id);
		model.addAttribute("msg1", appmsg.appsMsg.get("deleteMsg"));
		//get all book after deletation of record
		bookList=service.getAllBook();
		model.addAttribute("bookList", bookList);
		model.addAttribute("book", new BookDetails());
		return "book_page";
	}
	
	@RequestMapping(value="/editBook",method=RequestMethod.GET)
	public String editBook(Model model,HttpServletRequest req) {
		Integer id=0;
		List<BookDetails> bookList=null;
		BookDetails updatedBook=null;
		id=Integer.parseInt(req.getParameter("id"));
		bookList=service.getAllBook();
		model.addAttribute("bookList", bookList);
		//get updated object
		updatedBook=service.updateBook(id);
		//add object to model attribute
		model.addAttribute("book", updatedBook);
		return "book_page";
	}

}
