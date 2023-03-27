package pkg02;

import java.util.ArrayList;
import java.util.List;

/**
 * 데이터베이스
 */
public class Database {
	// 필드
	public List<Staff> staffList;
	
	
	// 생성자
	public Database() {
		staffList = new ArrayList<>();
	}
	// 사원 목록 출력화면에서 사용할 메소드 - staff ArrayList에 보내줌
	public List<Staff> getStaffList(){
		return staffList;
	}
	
	// 사원 추가 메소드
	public void addStaff(Staff staff) {
		this.staffList.add(staff);
	}

}
