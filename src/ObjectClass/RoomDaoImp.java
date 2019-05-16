package ObjectClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RoomDaoImp implements RoomDao{
	public void add(Room room){
		Connection cnn=DBUtil.openDB();
		String sql="insert into room(RoomNo,TypeNo,RoomFloor,Description)values(?,?,?,?)";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, room.getRoomNo());
			ps.setString(2, room.getTypeNo());
			ps.setInt(3, room.getRoomFloor());
			ps.setString(4,room.getDescription());
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
		String sql="delete from room where roomNo=?";
		String sql1="delete from roomthing where roomNo=?";
		String sql2="update customer set roomNo='ÒÑÉ¾³ý' where roomNo=?";
		try {
			PreparedStatement preparedStatement=cnn.prepareStatement(sql2);
			preparedStatement.setString(1, roomNo);
			preparedStatement.executeUpdate();
			PreparedStatement pStatement=cnn.prepareStatement(sql1);
			pStatement.setString(1, roomNo);
			pStatement.executeUpdate();
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
	
	public Room getRoomByNo(String roomNo){
		Connection cnn=DBUtil.openDB();
		String sql="select * from Room where RoomNo=?";
		System.out.println(roomNo);
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, roomNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			
			Room room=new Room();
			System.out.println(rs.getString(1));
			room.setRoomNo(rs.getString(1));
			room.setTypeNo(rs.getString(2));
			room.setRoomFloor(rs.getInt(3));
			room.setDescription(rs.getString(4));
			room.setStatus(rs.getString(5));
			return room;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(cnn);
		}
		
		return null;
		
	}
	
	
	public ArrayList<Room> getRoomsByDescription(String des){
		Connection cnn=DBUtil.openDB();
		String sql="select * from room where Description=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, des);
			ResultSet rs=ps.executeQuery();
			ArrayList<Room> roomList=new ArrayList<Room>();
			while(rs.next()){
				Room room=new Room();
				room.setRoomNo(rs.getString(1));
				room.setTypeNo(rs.getString(2));
				room.setRoomFloor(rs.getInt(3));
				room.setDescription(rs.getString(4));
				room.setStatus(rs.getString(5));
				roomList.add(room);
			}
			return roomList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
		return null;
	}
	
	public ArrayList<Room> getRoomsByRoomFloor(int floor){
		Connection cnn=DBUtil.openDB();
		String sql="select * from room where RoomFloor=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setInt(1, floor);
			ResultSet rs=ps.executeQuery();
			ArrayList<Room> roomList=new ArrayList<Room>();
			while(rs.next()){
				Room room=new Room();
				room.setRoomNo(rs.getString(1));
				room.setTypeNo(rs.getString(2));
				room.setRoomFloor(rs.getInt(3));
				room.setDescription(rs.getString(4));
				room.setStatus(rs.getString(5));
				roomList.add(room);
			}
			return roomList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
		return null;
	}
	
	public ArrayList<Room> getRoomsByTypeNo(String typeNo){
		Connection cnn=DBUtil.openDB();
		String sql="select * from room where TypeNo=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, typeNo);
			ResultSet rs=ps.executeQuery();
			ArrayList<Room> roomList=new ArrayList<Room>();
			while(rs.next()){
				Room room=new Room();
				room.setRoomNo(rs.getString(1));
				room.setTypeNo(rs.getString(2));
				room.setRoomFloor(rs.getInt(3));
				room.setDescription(rs.getString(4));
				room.setStatus(rs.getString(5));
				roomList.add(room);
			}
			return roomList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
		return null;
	}
	
	public ArrayList<Room> query(){
		
		Connection cnn=DBUtil.openDB();
		String sql="select * from room";
		try {
			Statement st=cnn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			ArrayList<Room> roomList=new ArrayList<Room>();
			while(rs.next()){
				Room room=new Room();
				room.setRoomNo(rs.getString(1));
				room.setTypeNo(rs.getString(2));
				room.setRoomFloor(rs.getInt(3));
				room.setDescription(rs.getString(4));
				room.setStatus(rs.getString(5));
				roomList.add(room);
			}
			return roomList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
		return null;
		}
	
	
	public void update(Room room){
		
		Connection cnn=DBUtil.openDB();
		String sql="update room set typeno=?,roomfloor=?,description=?,roomStatus=? where roomno=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, room.getTypeNo());
			ps.setInt(2,room.getRoomFloor());
			ps.setString(3, room.getDescription());
			ps.setString(4, room.getRoomNo());
			ps.setString(5, room.getStatus());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
	}


	@Override
	public List<Room> getRoomsByRoomStatus(String status) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select * from room where roomStatus=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, status);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<Room> roomList=new ArrayList<>();
			while(resultSet.next()) {
				Room room=new Room();
				room.setRoomNo(resultSet.getString(1));
				room.setTypeNo(resultSet.getString(2));
				room.setRoomFloor(resultSet.getInt(3));
				room.setDescription(resultSet.getString(4));
				room.setStatus(resultSet.getString(5));
				roomList.add(room);
			}
			return roomList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		return null;
	}


	@Override
	public int updateRoomStatusByRoomNo(String roomNo, String roomStatus) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="update room set roomstatus=? where roomNo=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, roomStatus);
			preparedStatement.setString(2, roomNo);
			int n=preparedStatement.executeUpdate();
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		return 0;
		
		
	}


	@Override
	public String getTypeNoByRoomNo(String roomNo) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select typeno from room where roomNo=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, roomNo);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				String typeNo=resultSet.getString(1);
				return typeNo;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		
		return null;
	}


	@Override
	public String getRoomStatusByRoomNo(String roomNo) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select roomstatus from room where roomNo=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, roomNo);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		return null;
	}


	@Override
	public List<Room> getRoomGroupbydes() {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		
		return null;
	}
	

}
