package ObjectClass;
import java.util.ArrayList;


public interface RoomTypeDao {
	public void add(RoomType rt);//����һ����������
	public void update(RoomType rt);//����һ����������
	public int delete(String typeNo);//���ͺ���ɾ��
	public RoomType getRoomByTypeNo(String typeNo);//ͨ������Ų���һ������
	public ArrayList<RoomType> getRoomsByPeopleNo(int peopleNo);//�����ܹ�����n�˵����з�������
	public ArrayList<RoomType> query();//��ʾ���з���
	public int getRoomPriceByTypeNo(String typeNo);

}
