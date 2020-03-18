package com.hadwinling.service.impl;

import java.util.List;

import com.hadwinling.dao.BookDAO;
import com.hadwinling.dao.impl.BookDAOImpl;
import com.hadwinling.entity.Book;
import com.hadwinling.service.BookService;

public class BookServiceImpl implements BookService{
	private BookDAO bookDAO=new BookDAOImpl();
	/* (non-Javadoc)
	 * @see com.gem.demo.service.BookService#findAllBooks()
	 */
	@Override
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return bookDAO.findAllBooks();
	}
	/* (non-Javadoc)
	 * @see com.gem.demo.service.BookService#delBook(int)
	 */
	@Override
	public boolean delBook(int id) {
		// TODO Auto-generated method stub
		return bookDAO.deleteBook(id)>0?true:false;
	}
	/* (non-Javadoc)
	 * @see com.gem.demo.service.BookService#addBook(com.gem.demo.entity.Book)
	 */
	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return bookDAO.addBook(book)>0?true:false;
	}
	@Override
	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookDAO.updateBook(book)>0?true:false;
	}
	@Override
	public Book findBookById(int id) {
		// TODO Auto-generated method stub
		return bookDAO.findBookById(id);
	}

}
