package edu.kh.todoList.model.service;

import java.sql.SQLException;
import java.util.Map;

import edu.kh.todoList.model.dto.Todo;

public interface TodoService {


	/** 할 일 목록 + 완료된 할 일 개수  조회
	 * @return map
	 * @throws SQLException
	 */
	Map<String, Object> selectAll() throws SQLException;

	int addTodo(String todoTitle, String todoContent) throws SQLException;

	
	/** 할 일 상세 조회
	 * @param todoNo
	 * @return todo
	 * @throws SQLException
	 */
	Todo selectTodo(int todoNo) throws SQLException;

	int changeComplete(int todoNo, String complete) throws SQLException;

	int updateTodo(Todo todo) throws SQLException ;

	int deleteTodo(int todoNo) throws SQLException;

	





}
