package org.formation.jsp;

public class DeptPair {
	private String deptNum;

	private String deptName;
	public DeptPair(String deptNum, String deptName) {
		super();
		this.deptNum = deptNum;
		this.deptName = deptName;
	}

	public String getDeptNum() {
		return deptNum;
	}

	public void setDeptNum(String deptNum) {
		this.deptNum = deptNum;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
