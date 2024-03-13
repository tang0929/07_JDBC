package edu.kh.dept.model.exception;

// 사용자 정의 예외 만드는 법
/* 아무 Exception 클래스를 상속받기
* + RuntimeException 또는 그 자식 예외를 상속받으면
* Unchecked Exception으로 설정된다
* 
*/

public class DepartmentInsertException extends RuntimeException {
	
	// 기본 생성자
	public DepartmentInsertException() {
		
		// 부모 생성자인 RuntimeException 호출
		super("부서 추가(INSERT) 도중 예외 발생(계약 조건 위배)");
	}
	
	// 매개 변수 생성자
	public DepartmentInsertException(String message) {
		super(message);
	}

}
