package ComplexObjectClass;

import java.util.List;

public interface EmptyRoomInformationTableDao {

	public List<EmptyRoomInformationTable> getTableByRoomStatus(String status);//ͨ������״̬���ɿշ�����Ϣ��
	public List<EmptyRoomInformationTable> getTableByRoomDescription(String description);
	public List<EmptyRoomInformationTable> getTableByFloor(int floor);
	public EmptyRoomInformationTable getRoomByRoomNo(String roomNo);
}
