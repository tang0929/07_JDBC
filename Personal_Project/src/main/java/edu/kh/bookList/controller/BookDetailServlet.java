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

@WebServlet("/book/detail")
public class BookDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			BookService service = new BookServiceImpl();
			
			int bookNo = Integer.parseInt(req.getParameter("bookNo"));
			
			Book book = service.selectBook(bookNo);
			
			if(book != null) {
				req.setAttribute("book", book);
				String path = "/WEB-INF/views/detail.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
			} else {
				req.getSession().setAttribute("message", "조회되는 정보가 없습니다.");
				resp.sendRedirect("/");
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
