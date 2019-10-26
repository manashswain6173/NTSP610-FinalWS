package com.manash.repositery;

import org.springframework.data.repository.CrudRepository;

import com.manash.entity.BookDetails;

public interface BookRepositery extends CrudRepository<BookDetails,Integer> {

}
