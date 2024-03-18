package edu.kh.bookList.model.service;

import static edu.kh.bookList.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.bookList.common.JDBCTemplate;
import edu.kh.bookList.model.dao.BookDAO;
import edu.kh.bookList.model.dao.BookDAOImpl;
import edu.kh.bookList.model.dto.Book;


public class BookServiceImpl implements BookService {

	private BookDAO dao = null;
	
	public BookServiceImpl() {
		dao = new BookDAOImpl();
	
	}

	
	
	@Override
	public Map<String, Object> selectAll() throws SQLException {
		Connection conn = getConnection();
		
		List<Book> bookList = dao.selectAll(conn);
		
		
		
		close(conn);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bookList",bookList);
	
		
		return map;
		
	}
	
	
	// 도서 추가
	@Override
	public int addBook(String bookTitle, String writer, String reviewWriter, int rate, String reviewContent)
			throws Exception {
		
		// 커넥션
		Connection conn = getConnection();
		
		int result = dao.addBook(conn, bookTitle, writer, reviewWriter, rate, reviewContent);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	@Override
	public Book selectBook(int bookNo) throws Exception {
		
		// 커넥션
		Connection conn = getConnection();
		
		Book book = dao.selectBook(conn, bookNo);
		
		close(conn);
		
		return book;
	}

	
	
	// 도서 삭제
	@Override
	public int deleteBook(int bookNo) throws Exception {
		Connection conn = getConnection();
		int result = dao.deleteBook(conn,bookNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

}
