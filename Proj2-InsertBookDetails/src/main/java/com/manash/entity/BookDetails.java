package com.manash.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BOOK_DETAILS")
@Data
public class BookDetails {

	@Id
	@Column(name="BOOKID")
	private int bookId;
	@Column(name="BOOKNAME")
	private String bookName;
	@Column(name="PRICE")
	private Double price;
	@Column(name="AUTHOR")
	private String author;
}
