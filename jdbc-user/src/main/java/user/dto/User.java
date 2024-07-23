package user.dto;

public class User {
	private int id;
	private String name;
	private String email; 
	private long phNo; 
	private String password; 
	private String dob; 
	private String qual;
	// 7 args constructor for data registration
	public User(int id, String name, String email, long phNo, String password, String dob, String qual) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phNo = phNo;
		this.password = password;
		this.dob = dob;
		this.qual = qual;
	}
	// 2 args constructor for login
	public User(long phNo, String password) {
		super();
		this.phNo = phNo;
		this.password = password;
	}
	public int getId() {
		return id;
	 }
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phNo=" + phNo + ", password=" + password
				+ ", dob=" + dob + ", qual=" + qual + "]";
	}
	

}
