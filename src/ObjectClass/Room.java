package ObjectClass;

public class Room {
	private String RoomNo;//房间编号
	private String TypeNo;//房间种类号码
	private int RoomFloor;//房间位置
	private String Description;//房间描述
	private String roomStatus;//房间状态空闲，预定，入住，清洁，维修
	
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
