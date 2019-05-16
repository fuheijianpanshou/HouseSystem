package ObjectClass;

import java.sql.Date;

import com.mysql.fabric.xmlrpc.base.Data;

public class Customer {
	private String CuNo;//顾客编号
	private String CuName;//顾客名称
	private String CuCard;//顾客身份证号码
	private String CuSex;//顾客性别
	private String CuPhone;//顾客电话号码
	private String CuPay;//顾客支付状态 已退定金  已付定金未结账  已结账 已付押金
	private String CuRoomNo;//目前顾客房间号 默认为零
	private String PastCuRoomNo;//顾客上一次居住的房间号，默认为零
	private String CuReserveTime=null;//顾客预定住房时间
	private String CuCheckTime=null;//顾客入住时间
	private int reserveTimeLong=1;
	
	
	
	public int getReserveTimeLong() {
		return reserveTimeLong;
	}
	public void setReserveTimeLong(int reserveTimeLong) {
		this.reserveTimeLong = reserveTimeLong;
	}
	public String getCuReserveTime() {
		return CuReserveTime;
	}
	public void setCuReserveTime(String cuReserveTime) {
		CuReserveTime = cuReserveTime;
	}
	public String getCuCheckTime() {
		return CuCheckTime;
	}
	public void setCuCheckTime(String cuCheckTime) {
		CuCheckTime = cuCheckTime;
	}
	public String getCuRoomNo() {
		return CuRoomNo;
	}
	public void setCuRoomNo(String cuRoomNo) {
		CuRoomNo = cuRoomNo;
	}
	public String getPastCuRoomNo() {
		return PastCuRoomNo;
	}
	public void setPastCuRoomNo(String pastCuRoomNo) {
		PastCuRoomNo = pastCuRoomNo;
	}
	public String getCuNo() {
		return CuNo;
	}
	public void setCuNo(String cuNo) {
		CuNo = cuNo;
	}
	public String getCuName() {
		return CuName;
	}
	public void setCuName(String cuName) {
		CuName = cuName;
	}
	public String getCuCard() {
		return CuCard;
	}
	public String getCuPay() {
		return CuPay;
	}
	public void setCuPay(String cuPay) {
		CuPay = cuPay;
	}
	public void setCuCard(String cuCard) {
		CuCard = cuCard;
	}
	public String getCuSex() {
		return CuSex;
	}
	public void setCuSex(String cuSex) {
		CuSex = cuSex;
	}
	public String getCuPhone() {
		return CuPhone;
	}
	public void setCuPhone(String cuPhone) {
		CuPhone = cuPhone;
	}
	

}
