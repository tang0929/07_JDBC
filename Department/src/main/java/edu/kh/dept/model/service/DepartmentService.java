package edu.kh.dept.model.service;

import java.sql.SQLException;
import java.util.List;

import edu.kh.dept.model.dto.Department;
import edu.kh.dept.model.exception.DepartmentInsertException;

public interface DepartmentService {

	// 선언되는 메서드는 모두 public abstract (추상 메서드)
	
	
	/** 모든 부서 조회
	 * @return deptList(부서 목록)
	 * @throws DepartmentInsertException
	 */
	List<Department> selectAll() throws DepartmentInsertException;

	
	/** 부서 추가 서비스
	 * @param dept
	 * @return result(삽입된 행의 개수)
	 * @throws DepartmentInsertException
	 */
	int insertDepartment(Department dept) throws DepartmentInsertException;
	
	
	
}




