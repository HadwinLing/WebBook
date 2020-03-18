package com.hadwinling.dao;

import java.util.List;

import com.hadwinling.entity.Book;

public interface BookDAO {
	// 查询所有
	List<Book> findAllBooks();

	// 通过编号查询
	Book findBookByBno(String bno);

	// 通过id查询
	Book findBookById(int id);

	// 新增
	int addBook(Book book);

	// 删除
	int deleteBook(int id);

	// 更新
	int updateBook(Book book);

}
