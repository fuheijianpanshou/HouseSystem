package ObjectClass;



public class HouseBill {
	private String billNo;
	private String billKind;//���붩���˻ض�������Ѻ��ʵ���տ�˿����㣬��Ʒ�տ������
	private String cuNo;
	private String userNo;
	private String Year;
	private String Month;
	private String Day;
	private int profit;
	
	
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getMonth() {
		return Month;
	}
	public void setMonth(String month) {
		Month = month;
	}
	public String getDay() {
		return Day;
	}
	public void setDay(String day) {
		Day = day;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getBillKind() {
		return billKind;
	}
	public void setBillKind(String billKind) {
		this.billKind = billKind;
	}
	public String getCuNo() {
		return cuNo;
	}
	public void setCuNo(String cuNo) {
		this.cuNo = cuNo;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	

}
