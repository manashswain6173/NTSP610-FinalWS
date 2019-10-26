package com.manash.command;

import lombok.Data;

@Data
public class BookCommand {
	
	private Integer bookId;
	private String bookName;
	private Double price;
	private String author;

}
