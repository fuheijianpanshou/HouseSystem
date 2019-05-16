package ObjectClass;
import java.util.List;


public interface RoomDao {
	public void add(Room ro);//����һ������
	public void update(Room ro);//����һ������ͨ�������
	public void delete(String roomNo);//ɾ��һ�������¼ͨ�������
	public Room getRoomByNo(String roomNo);//��ѯһ���������Ϣͨ�������
	public List<Room> getRoomsByTypeNo(String typeNo);//ͨ���������ͺŲ�ѯ�����͵����з���
	public List<Room> getRoomsByRoomFloor(int roomFloor);//ͨ������λ�ò�ѯ�������з���
	public List<Room> getRoomsByRoomStatus(String status);//ͨ������״̬���ҷ���
	public int updateRoomStatusByRoomNo(String roomNo,String roomStatus);//ͨ������Ÿ��·���״̬
	public List<Room> getRoomsByDescription(String de);//ͨ������������ѯ�������еķ���
	public List<Room> query();//��ʾ���з���
	public String getTypeNoByRoomNo(String roomNo);
	public String getRoomStatusByRoomNo(String roomNo);
	public List<Room> getRoomGroupbydes();
	

}
