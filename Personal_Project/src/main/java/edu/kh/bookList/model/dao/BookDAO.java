package edu.kh.bookList.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.bookList.model.dto.Book;

public interface BookDAO {

	
	List<Book> selectAll(Connection conn) throws SQLException;

	int addBook(Connection conn, String bookTitle, String writer, String reviewWriter, int rate, String reviewContent) throws Exception;

	Book selectBook(Connection conn, int bookNo) throws Exception;

	int deleteBook(Connection conn, int bookNo) throws Exception;

	int updateBook(Connection conn, Book book) throws Exception;

	


}