package edu.kh.dept.controller;

import java.io.IOException;
import java.sql.Connection;

import edu.kh.dept.common.JDBCTemplate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/department/selectAll")
// 현재 클래스를 Servlet으로 등록(서버 실행 시 객체 생성 + URL 매핑)
public class SelectAllServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Connection conn = JDBCTemplate.getConnection();
			
			System.out.println(conn);
			
			JDBCTemplate.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
