package ObjectClass;

import java.sql.Date;

import com.mysql.fabric.xmlrpc.base.Data;

public class Customer {
	private String CuNo;//�˿ͱ��
	private String CuName;//�˿�����
	private String CuCard;//�˿����֤����
	private String CuSex;//�˿��Ա�
	private String CuPhone;//�˿͵绰����
	private String CuPay;//�˿�֧��״̬ ���˶���  �Ѹ�����δ����  �ѽ��� �Ѹ�Ѻ��
	private String CuRoomNo;//Ŀǰ�˿ͷ���� Ĭ��Ϊ��
	private String PastCuRoomNo;//�˿���һ�ξ�ס�ķ���ţ�Ĭ��Ϊ��
	private String CuReserveTime=null;//�˿�Ԥ��ס��ʱ��
	private String CuCheckTime=null;//�˿���סʱ��
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
