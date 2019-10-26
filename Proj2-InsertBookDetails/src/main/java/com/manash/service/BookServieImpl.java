package com.manash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manash.dto.BookDTO;
import com.manash.entity.BookDetails;
import com.manash.repositery.BookRepositery;

@Service("bookService")
public class BookServieImpl implements BookService {
	
	@Autowired
	private BookRepositery repo;

	@Override
	public BookDetails saveBook(BookDTO dto) {
		//create Entity class object
		BookDetails entity=new BookDetails();
		//copy properties from dto to entity
		BeanUtils.copyProperties(dto,entity);
		//insert data into db 
		BookDetails savedBook=repo.save(entity);
		System.out.println(savedBook);
		return savedBook;
	}

	@Override
	public List<BookDetails> getAllBook() {
		//get all book details
		List<BookDetails> bookList=(List<BookDetails>) repo.findAll();
		return bookList;
	}

	@Override
	public void removeBook(Integer id) {
		//remove book details by id
		repo.deleteById(id);
	}

	@Override
	public BookDetails updateBook(Integer id) {
		//update book by id
		Optional<BookDetails> optional=repo.findById(id);
		return optional.get();
	}

}
