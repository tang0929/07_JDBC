package edu.kh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample2 {
	public static void main(String[] args) {
		
		// 입력받은 수보다 많이 받은 급여보다 많이 받는 사원의 사번, 이름, 급여, 직급명 조회
		
		
		
		/* 1. JDBC 객체 참조 변수 선언 */
		
		Connection conn = null; // DB 연결 정보를 가지고 있는 객체
		Statement stmt = null; // SQL 수행 후 결과 반환받는 객체
		ResultSet rs = null; // SELECT 결과를 저장하는 객체
		
		
		try {
			/* 2. DriverManager 객체를 이용해서 Connection 생성하기 */
			
			/* 2-1) Oracle JDBC Driver 객체를 메모리에 적재*/
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			/* 2-2) DB 연결 정보를 이용해 Connection */
			String type = "jdbc:oracle:thin:@"; // 드라이버 종류
			String host = "localhost"; // DB 서버 컴퓨터의 ip주소
			String port = ":1521"; // DB 서버 컴퓨터에 DB 프로그램 연결 번호
			String dbName = ":xe"; // DB 이름
			String userName = "KH_NTH"; // 사용자 계정
			String pw = "kh1234";
			
			
			conn = DriverManager.getConnection(type + host + port + dbName, userName, pw);
			
			
			
			/* 3. SQL 작성*/
			Scanner sc = new Scanner(System.in);
			
			System.out.print("검색할 급여 입력 : ");
			int input = sc.nextInt();
			System.out.println("---------------------------------------------------");
			
			String sql = "SELECT EMP_ID, EMP_NAME, SALARY, JOB_NAME "
					+ "FROM EMPLOYEE "
					+ "JOIN JOB USING (JOB_CODE) "
					+ "WHERE SALARY >= " + input
					+ " ORDER BY SALARY DESC";
			// 문장 이어쓰기이므로 띄어쓰기 항상 조심
			
			
			/* 4. Statement 객체 생성 */
			stmt = conn.createStatement();
			
			
			/* 5. Statement 객체를 이용해서 SQL 수행 후 결과 반환 받기 */
			rs = stmt.executeQuery(sql); 
			// SELECT 수행 시 rs (ResultSet)이 반환된다!!
			
			
			/* 6. ResultSet 객체를 1행 씩 접근하며 컬럼 값 얻어오기 */
			while(rs.next()) {
				// rs.next() : 다음 행으로 이동해서 행이 있으면 true 없으면 false
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_Name");
				int salary = rs.getInt("SALARY");
				String jobName = rs.getString("JOB_NAME");
				
				System.out.printf("%s / %s / %d / %s \n",empId, empName, salary, jobName);
			
				}
			
	
			
			
			
		}catch(Exception e) {
			// SQLException, ClassNotFoundException 한 번에 처리
			e.printStackTrace();
		} finally {
			
			try {
				/* 7. 사용 완료된 JDBC 객체 반환하기 (역순) */
				if(rs   != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
