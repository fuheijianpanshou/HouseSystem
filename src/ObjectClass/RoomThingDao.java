package ObjectClass;
import java.util.ArrayList;


public interface RoomThingDao {
	public void add(RoomThing roomthing);//添加一件物品
	public void deleteByThingNo(String thingNo);//通过物品好删除一件物品
	//public void deleteByThingName(String thingName);//通过物品名称删除一件物品
	public void deleteByRoomNo(String RoomNo);//通过房间号删除整个房间的
	public void delteThingByKey(String roomNo,String thingNo);
	public void update(RoomThing roomThing);//更新一件物品
	public ArrayList<RoomThing> getRoomThingByThingName(String thingName);//通过物品的名字查看这种物品的状态
	public RoomThing getRoomThingByThingNo(String thingNo);//通过物品号查看这种物品的状态
	public ArrayList<RoomThing> getRoomThingsByRoomNo(String RoomNo);//查看一个房间中的所有物品
	public ArrayList<RoomThing> query();//显示所有物品
	public int updateThingNuByKey(String roomNo,String thingNo,int amount);
	public int updateThingdownByKey(String roomNo,String thingNo,int amount);
	public int updateThingPriceByKey(String rooNo,String thingNo,int price);
	public String getThingNoByKey(String roomNo,String thingName);
	public int getThingPriceByKey(String roomNo,String thingNo);
	public int getRoomthingNuByKey(String roomNo,String thingNo);
	

}
