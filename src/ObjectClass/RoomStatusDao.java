package ObjectClass;
import java.util.List;


public interface RoomStatusDao {
	public void add(RoomStatus rs);//增添一条房间状态
	public void update(RoomStatus rs);//通过房间的号更新一个房间的状态
	public void delete(String roomNo);//删除一个房间通过房间号
	public List<RoomStatus> getRoomsByRoomStatus(String status);//查看所有某一状态的所有的房间
	public RoomStatus getRoomByRoomNo(String roomNo);//通过房间号查看某一房间的状态
	public List<RoomStatus> query();//查看所有房间

}
