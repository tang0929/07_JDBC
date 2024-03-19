package edu.kh.bookList.controller;

import java.io.IOException;

import edu.kh.bookList.model.dto.Book;
import edu.kh.bookList.model.service.BookService;
import edu.kh.bookList.model.service.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book/update")
public class BookUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			BookService service = new BookServiceImpl();
			
			int bookNo = Integer.parseInt(req.getParameter("bookNo"));
			
			Book book = service.selectBook(bookNo);
			
			if(book != null) {
				req.setAttribute("book", book);
				String path = "/WEB-INF/views/update.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
				
			} else {
				req.getSession().setAttribute("message", "존재하지 않습니다.");
				resp.sendRedirect("/");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			BookService service = new BookServiceImpl();
			
			int bookNo = Integer.parseInt(req.getParameter("bookNo"));
			int rate= Integer.parseInt(req.getParameter("rate"));
			String reviewContent = req.getParameter("reviewContent");
			
			
			Book book = new Book(bookNo, rate, reviewContent);
			
			int result = service.updateBook(book);
			
			String path = null;
			String message = null;
			
			if(result > 0) {
				path = "/book/detail?bookNo=" + bookNo;
				message = "수정하였습니다.";
			} else {
				path = "/book/detail?bookNo=" + bookNo;
				message = "수정 실패";
			}
			req.getSession().setAttribute("message", message);
			resp.sendRedirect(path);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
