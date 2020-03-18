package com.hadwinling.service;

import java.util.List;

import com.hadwinling.entity.Book;

public interface BookService {
	//查询所有书籍
	List<Book> findAllBooks();

	/**
	 * @param id
	 */
	boolean delBook(int id);

	/**
	 * @param book
	 */
	boolean addBook(Book book);
	
	boolean updateBook(Book book);

	Book findBookById(int id);
}
