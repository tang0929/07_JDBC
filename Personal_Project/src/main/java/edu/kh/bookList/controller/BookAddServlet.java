package edu.kh.bookList.controller;

import java.io.IOException;

import edu.kh.bookList.model.service.BookService;
import edu.kh.bookList.model.service.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/book/add")
public class BookAddServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			
		// 서비스 객체
		BookService service = new BookServiceImpl();
		
		// 파라미터
		String bookTitle = req.getParameter("bookTitle");
		String writer = req.getParameter("writer");
		String reviewWriter = req.getParameter("reviewWriter");
		int rate = Integer.parseInt(req.getParameter("rate"));
		String reviewContent = req.getParameter("reviewContent");
		
		// 결과 반환
		int result = service.addBook(bookTitle, writer, reviewWriter, rate, reviewContent);
		
		
		String message = null;
		
		if(result > 0) message = "도서 추가 성공";
		else message = "도서 추가 실패";
		
		
		HttpSession session = req.getSession();
		session.setAttribute("message", message);
		resp.sendRedirect("/");
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
