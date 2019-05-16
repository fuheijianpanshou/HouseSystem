package ObjectClass;
import java.util.ArrayList;


public interface RoomThingDao {
	public void add(RoomThing roomthing);//���һ����Ʒ
	public void deleteByThingNo(String thingNo);//ͨ����Ʒ��ɾ��һ����Ʒ
	//public void deleteByThingName(String thingName);//ͨ����Ʒ����ɾ��һ����Ʒ
	public void deleteByRoomNo(String RoomNo);//ͨ�������ɾ�����������
	public void delteThingByKey(String roomNo,String thingNo);
	public void update(RoomThing roomThing);//����һ����Ʒ
	public ArrayList<RoomThing> getRoomThingByThingName(String thingName);//ͨ����Ʒ�����ֲ鿴������Ʒ��״̬
	public RoomThing getRoomThingByThingNo(String thingNo);//ͨ����Ʒ�Ų鿴������Ʒ��״̬
	public ArrayList<RoomThing> getRoomThingsByRoomNo(String RoomNo);//�鿴һ�������е�������Ʒ
	public ArrayList<RoomThing> query();//��ʾ������Ʒ
	public int updateThingNuByKey(String roomNo,String thingNo,int amount);
	public int updateThingdownByKey(String roomNo,String thingNo,int amount);
	public int updateThingPriceByKey(String rooNo,String thingNo,int price);
	public String getThingNoByKey(String roomNo,String thingName);
	public int getThingPriceByKey(String roomNo,String thingNo);
	public int getRoomthingNuByKey(String roomNo,String thingNo);
	

}
