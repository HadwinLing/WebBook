package com.hadwinling.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hadwinling.dao.BookDAO;
import com.hadwinling.entity.Book;
import com.hadwinling.util.JDBCTemplate;
import com.hadwinling.util.PreparedStatementCreator;
import com.hadwinling.util.ResultSetExtractor;

public class BookDAOImpl implements BookDAO {

	@Override
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return (List<Book>) JDBCTemplate.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement create(Connection conn) throws SQLException {
				String sql = "select * from book";
				PreparedStatement psmt = null;
				psmt = conn.prepareStatement(sql);
				return psmt;
			}
		}, new ResultSetExtractor() {

			@Override
			public Object extractor(ResultSet rs) throws SQLException {
				List<Book> books = new ArrayList<Book>();
				while (rs.next()) {
					int id = rs.getInt(1);
					String bno = rs.getString(2);
					String bname = rs.getString(3);
					String author = rs.getString(4);
					double price = rs.getDouble(5);
					String mark = rs.getString(6);
					Book book = new Book(id, bno, bname, author, price, mark);
					books.add(book);
				}
				return books;
			}
		});
	}

	@Override
	public Book findBookByBno(String bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findBookById(int id) {
		// TODO Auto-generated method stub
		return (Book) JDBCTemplate.query(connection->{
			String sql = "select *from book where id= ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			return preparedStatement;
		}, rs->{
			Book book =null;
			if (rs.next()) {
				int id1 = rs.getInt(1);
				String bno = rs.getString(2);
				String bname = rs.getString(3);
				String author = rs.getString(4);
				double price = rs.getDouble(5);
				String mark = rs.getString(6);
				book = new Book(id1, bno, bname, author, price, mark);
			}
			return book;
		});
	}

	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		return JDBCTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement create(Connection conn) throws SQLException {
				String sql = "insert into book(bno,bname,author,price,mark) values(?,?,?,?,?)";
				PreparedStatement psmt = null;
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, book.getBno());
				psmt.setString(2, book.getBname());
				psmt.setString(3, book.getAuthor());
				psmt.setDouble(4, book.getPrice());
				psmt.setString(5, book.getMark());
				return psmt;
			}
		});
	}

	@Override
	public int deleteBook(int id) {
		// TODO Auto-generated method stub
		return JDBCTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement create(Connection conn) throws SQLException {
				String sql = "delete from book  where id=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, id);
				return psmt;
			}
		});
	}

	@Override
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		return JDBCTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement create(Connection conn) throws SQLException {
				String sql = "update book set bname=?,author=?,price=?,mark=? where bno=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, book.getBname());
				psmt.setString(2, book.getAuthor());
				psmt.setDouble(3, book.getPrice());
				psmt.setString(4, book.getMark());
				psmt.setString(5, book.getBno());
				return psmt;
			}
		});
	}

}
