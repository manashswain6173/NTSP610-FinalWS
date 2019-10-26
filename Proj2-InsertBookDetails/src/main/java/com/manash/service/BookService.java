package com.manash.service;

import java.util.List;

import com.manash.dto.BookDTO;
import com.manash.entity.BookDetails;

public interface BookService {

	public BookDetails saveBook(BookDTO dto);
	public List<BookDetails> getAllBook();
	public void removeBook(Integer id);
	public BookDetails updateBook(Integer id);
}
