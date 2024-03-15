package edu.kh.todoList.model.dao;

import static  edu.kh.todoList.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.todoList.model.dto.Todo;

// DAO(Data Access Object) : DB에 접근하는 객체(SQL 수행하고 결과 반환 받기)
public class TodoDAOImpl implements TodoDAO{
	
	// JDBC 객체 참조 변수 선언
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	// Properties 객체 참조 변수 선언
	private Properties prop = null;
	

	// 기본생성자로 객체 생성 시 Properties 객체 생성 + xml 파일 내용 읽어오기
	public TodoDAOImpl() {
		try {
			prop = new Properties();
			String path = TodoDAOImpl.class.getResource("/edu/kh/todoList/sql/sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(path));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Todo> selectAll(Connection conn) throws SQLException {

		// 결과용 저장 변수 선언/ 객체 생성
		List<Todo> todoList = new ArrayList<Todo>();
	
		
		try {
			String sql = prop.getProperty("selectAll");
			stmt = conn.createStatement();
			
			
			// SQL 수행 후 결과 반환 받기
			rs = stmt.executeQuery(sql);
			
			
			// 조회 결과 한 행씩 접근하기
			while(rs.next()) {
				int todoNo = rs.getInt("TODO_NO");
				String todoTitle = rs.getString("TODO_TITLE");
				String complete = rs.getString("COMPLETE");
				String regDate = rs.getString("REG_DATE");		
				
				// TODO 객체 생성해서 값 세팅 후 todoList 추가
				Todo todo = new Todo(todoNo, todoTitle, complete, regDate);
				todoList.add(todo);
				
				
			}
			
		} finally {
			close(rs);
			close(stmt);
			
		}
		return todoList;
	}
	
	


	// 완료된 할 일 개수 조회
	@Override
	public int getCompleteCount(Connection conn) throws SQLException {
		int completeCount = 0;
		
		try {
			String sql = prop.getProperty("getCompleteCount");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			// GROUP BY가 없는 count 그룹 함수의 결과는 1행만 나옴
			// -> if문을 이용해 조회 결과 행 접근
			if(rs.next()) {
				completeCount = rs.getInt(1); // 1번 컬럼값 가져옴
			}
			
			
		}finally {
			close(rs);
			close(stmt);
			
		}
		
		
		return completeCount;
	}
	
	
	
	
	@Override
	public int addTodo(Connection conn, String todoTitle, String todoContent) throws SQLException {
		int result = 0; // 결과 저장용 변수
		
		try {
			String sql = prop.getProperty("addTodo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, todoTitle);
			pstmt.setString(2, todoContent);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
			
		}
		return result;
	}
	
	
	@Override
	public Todo selectTodo(Connection conn, int todoNo) throws SQLException {
		
		// 결과 저장용 변수 선언/객체 생성
		Todo todo = null;
		
		try {
			String sql = prop.getProperty("selectTodo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, todoNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 조회 결과가 있어도 1행밖에 없으므로 if사용이 효율적임
				
				todo = new Todo();
				todo.setTodoNo(rs.getInt("TODO_NO"));
				todo.setTodoTitle(rs.getString("TODO_TITLE"));
				todo.setTodoContent(rs.getString("TODO_CONTENT"));
				todo.setComplete(rs.getString("COMPLETE"));
				todo.setRegDate(rs.getString("REG_DATE"));
				
			} 
			
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return todo;
	} 
	
	@Override
	public int changeComplete(Connection conn, int todoNo, String complete) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("changeComplete");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, complete);
			pstmt.setInt(2, todoNo);
			
			result = pstmt.executeUpdate();
			
			
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	@Override
	public int updateTodo(Connection conn, Todo todo) throws SQLException{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateTodo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, todo.getTodoTitle());
			pstmt.setString(2, todo.getTodoContent());
			pstmt.setInt(3, todo.getTodoNo());
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	

	@Override
	public int deleteTodo(Connection conn, int todoNo) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteTodo");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt   (1, todoNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	

}
