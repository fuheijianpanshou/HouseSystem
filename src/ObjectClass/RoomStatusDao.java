package ObjectClass;
import java.util.List;


public interface RoomStatusDao {
	public void add(RoomStatus rs);//����һ������״̬
	public void update(RoomStatus rs);//ͨ������ĺŸ���һ�������״̬
	public void delete(String roomNo);//ɾ��һ������ͨ�������
	public List<RoomStatus> getRoomsByRoomStatus(String status);//�鿴����ĳһ״̬�����еķ���
	public RoomStatus getRoomByRoomNo(String roomNo);//ͨ������Ų鿴ĳһ�����״̬
	public List<RoomStatus> query();//�鿴���з���

}
