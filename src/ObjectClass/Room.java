package ObjectClass;

public class Room {
	private String RoomNo;//������
	private String TypeNo;//�����������
	private int RoomFloor;//����λ��
	private String Description;//��������
	private String roomStatus;//����״̬���У�Ԥ������ס����࣬ά��
	
	public String getStatus() {
		return roomStatus;
	}
	public void setStatus(String status) {
		this.roomStatus = status;
	}
	public String getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(String roomNo) {
		RoomNo = roomNo;
	}
	public String getTypeNo() {
		return TypeNo;
	}
	public void setTypeNo(String typeNo) {
		TypeNo = typeNo;
	}
	public int getRoomFloor() {
		return RoomFloor;
	}
	public void setRoomFloor(int roomFloor) {
		RoomFloor = roomFloor;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	

}
