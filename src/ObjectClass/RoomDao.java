package ObjectClass;
import java.util.List;


public interface RoomDao {
	public void add(Room ro);//增添一个房间
	public void update(Room ro);//更新一个房间通过房间号
	public void delete(String roomNo);//删除一个房间记录通过房间号
	public Room getRoomByNo(String roomNo);//查询一个房间的信息通过房间号
	public List<Room> getRoomsByTypeNo(String typeNo);//通过房间类型号查询该类型的所有房间
	public List<Room> getRoomsByRoomFloor(int roomFloor);//通过房间位置查询该类所有房间
	public List<Room> getRoomsByRoomStatus(String status);//通过房间状态查找房间
	public int updateRoomStatusByRoomNo(String roomNo,String roomStatus);//通过房间号更新房间状态
	public List<Room> getRoomsByDescription(String de);//通过房间描述查询该类所有的房间
	public List<Room> query();//显示所有房间
	public String getTypeNoByRoomNo(String roomNo);
	public String getRoomStatusByRoomNo(String roomNo);
	public List<Room> getRoomGroupbydes();
	

}
