package edu.kh.bookList.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.kh.bookList.model.dto.Book;


public interface BookService {

	// 도서 목록 조회
	Map<String, Object> selectAll() throws SQLException;

	int addBook(String bookTitle, String writer, String reviewWriter, int rate, String reviewContent) throws Exception;

	Book selectBook(int bookNo) throws Exception;

	int deleteBook(int bookNo) throws Exception;

	int updateBook(Book book) throws Exception;
	

	
}