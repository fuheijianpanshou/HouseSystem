package ObjectClass;
import java.util.ArrayList;


public interface RoomTypeDao {
	public void add(RoomType rt);//增添一条房间类型
	public void update(RoomType rt);//更新一条房间类型
	public int delete(String typeNo);//类型号码删除
	public RoomType getRoomByTypeNo(String typeNo);//通过房间号查找一个房间
	public ArrayList<RoomType> getRoomsByPeopleNo(int peopleNo);//查找能够容纳n人的所有房间类型
	public ArrayList<RoomType> query();//显示所有房间
	public int getRoomPriceByTypeNo(String typeNo);

}
