package ObjectClass;
import java.util.ArrayList;
import java.util.List;


public interface CustomerDao {
	public void add(Customer cu);//����һ���˿���Ϣ
	public void update(Customer cu);//ͨ���˿ͱ�Ÿ���������Ϣ
	public void updateCuPayByCuPhone(String phone,String payStatus);//ͨ���ֻ�������¹˿�֧��״̬
	public void updateCuPayByCuNo(String cuNo,String payStatus);
	public int deleteByCuNo(String CuNo);//ͨ���˿����֤����ɾ���ù˿���Ϣ
	//public void deleteByCuName(String CuName);//ͨ���˿�����ɾ���ù˿͵���Ϣ
	public void deleteByCuPhone(String Cuphone);//ͨ���˿͵ĵ绰����ɾ���ù˿�
	public ArrayList<Customer> getCustomerByName(String CuName);//ͨ���˿͵����ֲ��Ҹù˿͵���Ϣ
	public Customer getCustomerByCuCard(String CuCard);//ͨ���˿͵����֤������Ҹù˿͵���Ϣ
	public Customer getCustomerByCuPhone(String CuPhone);//ͨ���˿͵绰������Ҹù˿͵���Ϣ
	public Customer getCustomerByCuNo(String cuNO);//ͨ���˿ͺò��Ҹù˿���Ϣ
	public ArrayList<Customer> query();//�鿴���й˿͵���Ϣ
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
