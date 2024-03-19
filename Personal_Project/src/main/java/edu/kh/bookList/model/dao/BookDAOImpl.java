package edu.kh.bookList.model.dao;

import static  edu.kh.bookList.common.JDBCTemplate.*;
import static edu.kh.bookList.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.bookList.model.dto.Book;

public class BookDAOImpl implements BookDAO{

	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	Properties prop = null;
	
	public BookDAOImpl() {
		try {
			prop = new Properties();
			String path = BookDAOImpl.class.getResource("/edu/kh/bookList/sql/sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(path));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 도서 목록 조회
	@Override
	public List<Book> selectAll(Connection conn) throws SQLException {
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			String sql = prop.getProperty("selectAll");
			
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				int bookNo = rs.getInt("BOOK_NO");
				String bookTitle = rs.getString("BOOK_TITLE");
				String writer = rs.getString("WRITER");
				String reviewWriter = rs.getString("REVIEW_WRITER");
				int rate = rs.getInt("RATE");
				String regDate = rs.getString("REG_DATE");
				
				Book book = new Book(bookNo, bookTitle, writer,reviewWriter, rate, regDate);
				bookList.add(book);
				
			}
			
			
			
		} finally {       
			close(rs);
			close(stmt);
			
		}
		
		return bookList;
	}
	
	
	// 도서 추가
	@Override
	public int addBook(Connection conn, String bookTitle, String writer, String reviewWriter, int rate,
			String reviewContent) throws Exception {


		int result = 0;
		
		try {
			String sql = prop.getProperty("addBook");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bookTitle);
			pstmt.setString(2, writer);
			pstmt.setString(3, reviewContent);
			pstmt.setString(4, reviewWriter);
			pstmt.setInt(5, rate);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
			
			
		}
		return result;
	}

	
	
	
	
	// 도서 상세 조회하기
	@Override
	public Book selectBook(Connection conn, int bookNo) throws Exception {
		
		Book book = null;
		
		try {
			String sql = prop.getProperty("selectBook");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookNo);

			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				book = new Book();
				
				book.setBookNo(rs.getInt("BOOK_NO"));
				book.setBookTitle(rs.getString("BOOK_TITLE"));
				book.setWriter(rs.getString("WRITER"));
				book.setReviewContent(rs.getString("REVIEW_CONTENT"));
				book.setReviewWriter(rs.getString("REVIEW_WRITER"));
				book.setRate(rs.getInt("RATE"));
				book.setRegDate(rs.getString("REG_DATE"));
			}
			
			
		} finally {
			
			close(rs);
			close(pstmt);
			
			
		}
		
	
		
		return book;
	}
	
	
	// 도서 삭제
	@Override
	public int deleteBook(Connection conn, int bookNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteBook");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	// 도서 수정
	
	@Override
	public int updateBook(Connection conn, Book book) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateBook");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getRate());
			pstmt.setString(2, book.getReviewContent());
			pstmt.setInt(3, book.getBookNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		return result;
	}
}