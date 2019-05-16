package ObjectClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OutedRoomThingDaoImp implements OutedRoomThingDao{

	@Override
	public void add(OutedRoomThing outedRoomThing) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		System.out.println(outedRoomThing.getCuNo()+" "+outedRoomThing.getRoomNo());
		String sql="insert into outedroomthing(CuNo,RoomNo,ThingNo,ThingPrice,ThingoutAmount,PayMoney,Thingname)values(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, outedRoomThing.getCuNo());
			preparedStatement.setString(2, outedRoomThing.getRoomNo());
			preparedStatement.setString(3, outedRoomThing.getThingNo());
			preparedStatement.setInt(4, outedRoomThing.getThingPrice());
			preparedStatement.setInt(5, outedRoomThing.getThingOutAmount());
			preparedStatement.setInt(6, outedRoomThing.getPayMoney());
			preparedStatement.setString(7, outedRoomThing.getThingName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		
		
	}

	@Override
	public List<OutedRoomThing> getOutedRoomThingsByCuNoAndRoomNo(String cuNO, String roomNo) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select * from outedRoomThing where cuno=? and roomno=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, cuNO);
			preparedStatement.setString(2, roomNo);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<OutedRoomThing> outedRoomThings=new ArrayList<>();
			while(resultSet.next()) {
				OutedRoomThing outedRoomThing=new OutedRoomThing();
				outedRoomThing.setCuNo(resultSet.getString(1));
				outedRoomThing.setRoomNo(resultSet.getString(2));
				outedRoomThing.setThingNo(resultSet.getString(3));
				outedRoomThing.setThingPrice(resultSet.getInt(4));
				outedRoomThing.setThingOutAmount(resultSet.getInt(5));
				outedRoomThing.setPayMoney(resultSet.getInt(6));
				outedRoomThing.setThingName(resultSet.getString(7));
				outedRoomThings.add(outedRoomThing);
			}
			return outedRoomThings;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		
		return null;
	}

	@Override
	public int deleteByCuNo(String cuNo) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="delete from outedroomthing where cuNo=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, cuNo);
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

}
