package pkg02;

public class Staff {
	private String id;		// 사원 ID
	private String name;	// 사원 이름
	private String jumin;	// 주민등록번호
	private String address; // 주소
	private String hiredate;// 입사일
	private String punchIn;	// 출근
	private String punchOut; // 퇴근
	
	public Staff() {
		
	}


	
	public Staff(String id, String name, String jumin, String address, String hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.jumin = jumin;
		this.address = address;
		this.hiredate = hiredate;
		this.punchIn = "";
		this.punchOut = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getPunchIn() {
		return punchIn;
	}

	public void setPunchIn(String punchIn) {
		this.punchIn = punchIn;
	}

	public String getPunchOut() {
		return punchOut;
	}

	public void setPunchOut(String punchOut) {
		this.punchOut = punchOut;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", jumin=" + jumin + ", address=" + address + ", hiredate="
				+ hiredate + ", punchIn=" + punchIn + ", punchOut=" + punchOut + "]";
	}



	
}
