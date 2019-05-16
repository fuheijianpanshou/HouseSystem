package ComplexObjectClass;

import java.util.List;

public interface EmptyRoomInformationTableDao {

	public List<EmptyRoomInformationTable> getTableByRoomStatus(String status);//通过房间状态生成空房间信息表
	public List<EmptyRoomInformationTable> getTableByRoomDescription(String description);
	public List<EmptyRoomInformationTable> getTableByFloor(int floor);
	public EmptyRoomInformationTable getRoomByRoomNo(String roomNo);
}
