package edu.kh.bookList.model.dto;

public class Book {
	
	private int bookNo;  // 번호
	private String bookTitle; // 책 제목
	private String writer; // 책 작가
	private String reviewContent; // 리뷰내용
	private String reviewWriter; // 리뷰 작성자
	private int rate; // 평점
	private String regDate; // 작성일
	
	
	public Book() {
		
		
	}

	public Book(int bookNo, String bookTitle, String writer, String reviewWriter, int rate, String regDate) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		this.reviewWriter = reviewWriter;
		this.rate = rate;
		this.regDate = regDate;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getRegDate() {
		return regDate;
	}

	public Book(int bookNo, int rate, String reviewContent) {
		super();
		this.bookNo = bookNo;
		this.rate = rate;
		this.reviewContent = reviewContent;
		
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", writer=" + writer + ", reviewContent="
				+ reviewContent + ", reviewWriter=" + reviewWriter + ", rate=" + rate + ", regDate=" + regDate + "]";
	}
	
	
	
	

}
