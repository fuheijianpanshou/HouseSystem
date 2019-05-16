package ObjectClass;

public class User {
	private int UserNo;
	public int getUserNo() {
		return UserNo;
	}
	public void setUserNo(int userNo) {
		UserNo = userNo;
	}
	private String UserName;//职工姓名
	private String UserPhone;//职工电话
	private String UserAdress;//职工地址
	private String UserPassword;//职工密码
	private String UserPosition;//职工职位
	private String UserSex;
	
	public String getUserPosition() {
		return UserPosition;
	}
	public void setUserPosition(String userPosition) {
		UserPosition = userPosition;
	}
	public String getUserSex() {
		return UserSex;
	}
	public void setUserSex(String userSex) {
		UserSex = userSex;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPhone() {
		return UserPhone;
	}
	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}
	public String getUserAdress() {
		return UserAdress;
	}
	public void setUserAdress(String userAdress) {
		UserAdress = userAdress;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	

}
