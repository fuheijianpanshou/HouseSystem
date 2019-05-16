package ObjectClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class RoomThingDaoImp implements RoomThingDao{

	@Override
	public void add(RoomThing roomthing) {
		Connection cnn=DBUtil.openDB();
		String sql="insert into RoomThing(RoomNo,ThingNo,ThingPrice,ThingAmount,ThingName)values(?,?,?,?,?)";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, roomthing.getRoomNo());
			ps.setString(2, roomthing.getThingNo());
			ps.setInt(3, roomthing.getThingPrice());
			ps.setInt(4, roomthing.getThingAmount());
			ps.setString(5, roomthing.getThingName());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
	}

	@Override
	public void deleteByRoomNo(String RoomNo) {
		Connection cnn=DBUtil.openDB();
		String sql="delete from RoomThing where RoomNo=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, RoomNo);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
		
	}

	//@Override
	/*public void deleteByThingName(String thingName) {
		Connection cnn=DBUtil.openDB();
		String sql="delete from RoomThing where ThingName=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, thingName);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
	}*/

	@Override
	public void deleteByThingNo(String thingNo) {
		Connection cnn=DBUtil.openDB();
		String sql="delete from RoomThing where ThingNo=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, thingNo);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
	}

	@Override
	public ArrayList<RoomThing> getRoomThingByThingName(String thingName) {
		Connection cnn=DBUtil.openDB();
		String sql="select * from RoomThing where ThingName=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ArrayList<RoomThing> roomThingList=new ArrayList<RoomThing>();
			ps.setString(1, thingName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				RoomThing rt=new RoomThing();
				rt.setRoomNo(rs.getString(1));
				rt.setThingNo(rs.getString(2));
				rt.setThingPrice(rs.getInt(3));
				rt.setThingAmount(rs.getInt(4));
				rt.setThingName(rs.getString(5));
				roomThingList.add(rt);
			}
			return roomThingList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
		return null;
	}

	@Override
	public RoomThing getRoomThingByThingNo(String thingNo) {
		Connection cnn=DBUtil.openDB();
		String sql="select * from RoomThing where ThingNo=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, thingNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				RoomThing rt=new RoomThing();
				rt.setRoomNo(rs.getString(1));
				rt.setThingNo(rs.getString(2));
				rt.setThingPrice(rs.getInt(3));
				rt.setThingAmount(rs.getInt(4));
				rt.setThingName(rs.getString(5));
				return rt;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		return null;
	}

	@Override
	public ArrayList<RoomThing> getRoomThingsByRoomNo(String RoomNo) {
		Connection cnn=DBUtil.openDB();
		String sql="select * from RoomThing where RoomNo=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, RoomNo);
			ResultSet rs=ps.executeQuery();
			ArrayList<RoomThing> roomThingList=new ArrayList<RoomThing>();
			while(rs.next()){
				RoomThing rt=new RoomThing();
				rt.setRoomNo(rs.getString(1));
				rt.setThingNo(rs.getString(2));
				rt.setThingPrice(rs.getInt(3));
				rt.setThingAmount(rs.getInt(4));
				rt.setThingName(rs.getString(5));
				roomThingList.add(rt);
			}
			
			return roomThingList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		return null;
	}

	@Override
	public ArrayList<RoomThing> query() {
		Connection cnn=DBUtil.openDB();
		String sql="select * from RoomThing";
		try {
			Statement st=cnn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			ArrayList<RoomThing> roomThingList=new ArrayList<RoomThing>();
			while(rs.next()){
				RoomThing rt=new RoomThing();
				rt.setRoomNo(rs.getString(1));
				rt.setThingNo(rs.getString(2));
				rt.setThingPrice(rs.getInt(3));
				rt.setThingAmount(rs.getInt(4));
				rt.setThingName(rs.getString(5));
				roomThingList.add(rt);
			}
			
			return roomThingList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		return null;
	}

	@Override
	public void update(RoomThing roomThing) {
		Connection cnn=DBUtil.openDB();
		String sql="update RoomThing set RoomNo=?,ThingPrice=?,ThingAmount=?,ThingName=? where ThingNo=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, roomThing.getRoomNo());
			ps.setInt(2, roomThing.getThingPrice());
			ps.setInt(3, roomThing.getThingAmount());
			ps.setString(4, roomThing.getThingName());
			ps.setString(5, roomThing.getThingNo());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
		
	}

	@Override
	public int updateThingNuByKey(String roomNo, String thingNo,int amount) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="update roomthing set thingamount=thingamount+? where roomNo=? and thingNo=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, amount);
			preparedStatement.setString(2, roomNo);
			preparedStatement.setString(3, thingNo);
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
	public int updateThingPriceByKey(String rooNo, String thingNo,int price) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="update roomthing set thingprice=? where roomNo=? and thingNo=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, price);
			preparedStatement.setString(2, rooNo);
			preparedStatement.setString(3, thingNo);
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
	public void delteThingByKey(String roomNo, String thingNo) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="delete from roomthing where roomNo=? and thingNo=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, roomNo);
			preparedStatement.setString(2, thingNo);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		
		
	}

	@Override
	public int updateThingdownByKey(String roomNo, String thingNo, int amount) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="update roomthing set thingamount=thingamount-? where roomNo=? and thingNo=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, amount);
			preparedStatement.setString(2, roomNo);
			preparedStatement.setString(3, thingNo);
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
	public String getThingNoByKey(String roomNo, String thingName) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select thingNo from roomthing where roomNo=? and thingName=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, roomNo);
			preparedStatement.setString(2, thingName);
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
	public int getThingPriceByKey(String roomNo, String thingNo) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select thingprice from roomthing where roomNo=? and thingNo=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, roomNo);
			preparedStatement.setString(2, thingNo);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		
		return 0;
	}

	@Override
	public int getRoomthingNuByKey(String roomNo, String thingNo) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select thingAmount from roomthing where roomNo=? and thingNo=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, roomNo);
			preparedStatement.setString(2, thingNo);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		
		
		return 0;
	}
	

}
