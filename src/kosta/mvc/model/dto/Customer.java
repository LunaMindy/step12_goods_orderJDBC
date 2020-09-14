package kosta.mvc.model.dto;

public class Customer {
  private String userId;
  private String userPwd;
  private String userName;
  private String regDate;
  
  public Customer() {}
	public Customer(String userId, String userPwd, String userName, String regDate) {
	super();
	this.userId = userId;
	this.userPwd = userPwd;
	this.userName = userName;
	this.regDate = regDate;
}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
  
  
  
}
