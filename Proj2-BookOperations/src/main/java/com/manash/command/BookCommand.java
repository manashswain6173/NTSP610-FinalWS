package com.manash.command;

import lombok.Data;

@Data
public class BookCommand {
	
	private int bookId;
	private String bookName;
	private  int price;
	private String author;

}
