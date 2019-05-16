package ObjectClass;
import java.util.ArrayList;
import java.util.List;


public interface CustomerDao {
	public void add(Customer cu);//插入一条顾客信息
	public void update(Customer cu);//通过顾客编号更新其他信息
	public void updateCuPayByCuPhone(String phone,String payStatus);//通过手机号码更新顾客支付状态
	public void updateCuPayByCuNo(String cuNo,String payStatus);
	public int deleteByCuNo(String CuNo);//通过顾客身份证号码删除该顾客信息
	//public void deleteByCuName(String CuName);//通过顾客名字删除该顾客的信息
	public void deleteByCuPhone(String Cuphone);//通过顾客的电话号码删除该顾客
	public ArrayList<Customer> getCustomerByName(String CuName);//通过顾客的名字查找该顾客的信息
	public Customer getCustomerByCuCard(String CuCard);//通过顾客的身份证号码查找该顾客的信息
	public Customer getCustomerByCuPhone(String CuPhone);//通过顾客电话号码查找该顾客的信息
	public Customer getCustomerByCuNo(String cuNO);//通过顾客好查找该顾客信息
	public ArrayList<Customer> query();//查看所有顾客的信息
	public void swapRoomByCuPhone(String phone,String roomNo);
	public String getRoomNoByCuNo(String cuNo);
	public String getRoomNoByCuPhone(String phone);
	public String getPayStatusByCuNo(String cuNo);
	public String getPayStatusByCuPhone(String phone);
	public int getTimeLongByPhone(String phone);
	public void addCheckCustomer(Customer cu);
	public String getCuNoByCuPhone(String cuPhone);
	public List<Customer> getCustomerByPayStatus(String payStatus);
	public int updatePastRoomNoByCuNo(String cuNo,String roomNo);
	

}
