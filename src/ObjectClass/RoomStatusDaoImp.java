package ObjectClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class RoomStatusDaoImp implements RoomStatusDao{
	public void add(RoomStatus roomStatus){
		Connection cnn=DBUtil.openDB();
		String sql="insert into roomstatus(roomno,status)values(?,?)";
		PreparedStatement ps;
		try {
			ps = cnn.prepareStatement(sql);
			ps.setString(1, roomStatus.getRoomNo());
			ps.setString(2, roomStatus.getStatus());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
	}
	public void delete(String roomNo){
		Connection cnn=DBUtil.openDB();
		String sql="delete from roomstatus where roomno=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, roomNo);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
	}
	
	public RoomStatus getRoomByRoomNo(String roomNo){
		Connection cnn=DBUtil.openDB();
		String sql="select * from RoomStatus where roomNo=?";
		PreparedStatement ps;
		try {
			ps = cnn.prepareStatement(sql);
			ps.setString(1, roomNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				RoomStatus roomStatus=new RoomStatus();
				roomStatus.setRoomNo(roomNo);
				roomStatus.setStatus(rs.getString(2));
				return roomStatus;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
		return null;
	}
	
	
	
	public ArrayList<RoomStatus> getRoomsByRoomStatus(String status){
		Connection cnn=DBUtil.openDB();
		String sql="select * from RoomStatus where status=?";
		try {
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, status);
			ResultSet rs=ps.executeQuery();
			ArrayList<RoomStatus> statusList=new ArrayList<RoomStatus>();
			while(rs.next()){
				RoomStatus roomStatus=new RoomStatus();
				roomStatus.setRoomNo(rs.getString(1));
				roomStatus.setStatus(rs.getString(2));
				statusList.add(roomStatus);
			}
			return statusList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ArrayList<RoomStatus> query(){
		Connection cnn=DBUtil.openDB();
		String sql="select * from RoomStatus";
		try {
			Statement st=cnn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			ArrayList<RoomStatus> statusList=new ArrayList<RoomStatus>();
			while(rs.next()){
				RoomStatus roomStatus=new RoomStatus();
				roomStatus.setRoomNo(rs.getString(1));
				roomStatus.setStatus(rs.getString(2));
				statusList.add(roomStatus);
			}
			return statusList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void update(RoomStatus roomStatus){
		Connection cnn=DBUtil.openDB();
		String sql="update RoomStatus set status=? where roomNo=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, roomStatus.getStatus());
			ps.setString(2, roomStatus.getRoomNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
	}
}
