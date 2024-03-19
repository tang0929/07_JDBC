package edu.kh.bookList.model.dao;

import java.io.IOException;

import edu.kh.bookList.model.service.BookService;
import edu.kh.bookList.model.service.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book/delete")
public class DeleteBookServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			BookService service = new BookServiceImpl();
			
			int bookNo = Integer.parseInt(req.getParameter("bookNo"));
			
			int result = service.deleteBook(bookNo);
			
			String path = null;
			
			String message = null;
			
			if(result > 0) {
				path = "/";
				message = "해당 도서 정보와 리뷰가 삭제되었습니다.";
			} else {
				path = "/book/detail?bookNo=" + bookNo;
				message = "삭제실패";
				
			}
			
			req.getSession().setAttribute("message", message);
			resp.sendRedirect(path);
			
			
		}
			catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		
		
		
	}