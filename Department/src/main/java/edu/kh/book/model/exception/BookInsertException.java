package edu.kh.book.model.exception;

public class BookInsertException extends RuntimeException{
	
	public BookInsertException() {
		super("입력하지 않은 칸이 존재합니다.");
	}

	public BookInsertException (String message) {
		super(message);
	}
}
