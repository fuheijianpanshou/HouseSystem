package ComplexObjectClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ObjectClass.DBUtil;

public class EmptyRoomInformationTableDaoImp implements EmptyRoomInformationTableDao{

	@Override
	public List<EmptyRoomInformationTable> getTableByRoomStatus(String status) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select RoomNo,RoomFloor,Description,typename,typearea,typeprice,peoplenu from room,roomtype where room.typeno=roomtype.typeno and roomstatus=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, status);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<EmptyRoomInformationTable> emptyRoomInformationTables=new ArrayList<>();
			while(resultSet.next()) {
				EmptyRoomInformationTable emptyRoomInformationTable=new EmptyRoomInformationTable();
				emptyRoomInformationTable.setRoomNo(resultSet.getString(1));
				emptyRoomInformationTable.setRoomFloor(resultSet.getInt(2));
				emptyRoomInformationTable.setRoomDescription(resultSet.getString(3));
				emptyRoomInformationTable.setTypeName(resultSet.getString(4));
				emptyRoomInformationTable.setTypeArea(resultSet.getInt(5));
				emptyRoomInformationTable.setTypePrice(resultSet.getInt(6));
				emptyRoomInformationTable.setPeopleNu(resultSet.getInt(7));
				emptyRoomInformationTables.add(emptyRoomInformationTable);
			}
			return emptyRoomInformationTables;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		return null;
	}

	@Override
	public List<EmptyRoomInformationTable> getTableByRoomDescription(String description) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select RoomNo,RoomFloor,Description,typename,typearea,typeprice,peoplenu,roomStatus from room,roomtype where room.typeno=roomtype.typeno and description=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, description);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<EmptyRoomInformationTable> emptyRoomInformationTables=new ArrayList<>();
			while(resultSet.next()) {
				EmptyRoomInformationTable emptyRoomInformationTable=new EmptyRoomInformationTable();
				emptyRoomInformationTable.setRoomNo(resultSet.getString(1));
				emptyRoomInformationTable.setRoomFloor(resultSet.getInt(2));
				emptyRoomInformationTable.setRoomDescription(resultSet.getString(3));
				emptyRoomInformationTable.setTypeName(resultSet.getString(4));
				emptyRoomInformationTable.setTypeArea(resultSet.getInt(5));
				emptyRoomInformationTable.setTypePrice(resultSet.getInt(6));
				emptyRoomInformationTable.setPeopleNu(resultSet.getInt(7));
				emptyRoomInformationTable.setRoomStatus(resultSet.getString(8));
				emptyRoomInformationTables.add(emptyRoomInformationTable);
			}
			return emptyRoomInformationTables;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		return null;
	}

	@Override
	public List<EmptyRoomInformationTable> getTableByFloor(int floor) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select RoomNo,RoomFloor,Description,typename,typearea,typeprice,peoplenu,roomStatus from room,roomtype where room.typeno=roomtype.typeno and roomfloor=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, floor);;
			ResultSet resultSet=preparedStatement.executeQuery();
			List<EmptyRoomInformationTable> emptyRoomInformationTables=new ArrayList<>();
			while(resultSet.next()) {
				EmptyRoomInformationTable emptyRoomInformationTable=new EmptyRoomInformationTable();
				emptyRoomInformationTable.setRoomNo(resultSet.getString(1));
				emptyRoomInformationTable.setRoomFloor(resultSet.getInt(2));
				emptyRoomInformationTable.setRoomDescription(resultSet.getString(3));
				emptyRoomInformationTable.setTypeName(resultSet.getString(4));
				emptyRoomInformationTable.setTypeArea(resultSet.getInt(5));
				emptyRoomInformationTable.setTypePrice(resultSet.getInt(6));
				emptyRoomInformationTable.setPeopleNu(resultSet.getInt(7));
				emptyRoomInformationTable.setRoomStatus(resultSet.getString(8));
				emptyRoomInformationTables.add(emptyRoomInformationTable);
			}
			return emptyRoomInformationTables;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		return null;
	}

	@Override
	public EmptyRoomInformationTable getRoomByRoomNo(String roomNo) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select RoomNo,RoomFloor,Description,typename,typearea,typeprice,peoplenu,roomstatus from room,roomtype where room.typeno=roomtype.typeno and Room.roomno=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, roomNo);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				EmptyRoomInformationTable emptyRoomInformationTable=new EmptyRoomInformationTable();
				emptyRoomInformationTable.setRoomNo(resultSet.getString(1));
				emptyRoomInformationTable.setRoomFloor(resultSet.getInt(2));
				emptyRoomInformationTable.setRoomDescription(resultSet.getString(3));
				emptyRoomInformationTable.setTypeName(resultSet.getString(4));
				emptyRoomInformationTable.setTypeArea(resultSet.getInt(5));
				emptyRoomInformationTable.setTypePrice(resultSet.getInt(6));
				emptyRoomInformationTable.setPeopleNu(resultSet.getInt(7));
				emptyRoomInformationTable.setRoomStatus(resultSet.getString(8));
				return emptyRoomInformationTable;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		return null;
	}

}
