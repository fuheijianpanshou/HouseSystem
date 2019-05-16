package ObjectClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.print.attribute.standard.RequestingUserName;


public class RoomTypeDaoImp implements RoomTypeDao{

	@Override
	public void add(RoomType rt) {
		Connection cnn=DBUtil.openDB();
		String sql="insert into RoomType(TypeNo,TypeName,TypeArea,TypePrice,PeopleNu)values(?,?,?,?,?)";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, rt.getTypeNo());
			ps.setString(2, rt.getTypeName());
			ps.setInt(3,rt.getTypeArea());
			ps.setInt(4, rt.getTypePrice());
			ps.setInt(5, rt.getPeopleNu());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
		
	}

	@Override
	public int delete(String typeNo) {
		Connection cnn=DBUtil.openDB();
		String sql="delete from RoomType where TypeNo=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, typeNo);
			int n=ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		return 0;
		
	}

	@Override
	public RoomType getRoomByTypeNo(String typeNo) {
		Connection cnn=DBUtil.openDB();
		String sql="select * from RoomType where TypeNo=?";
		PreparedStatement ps;
		try {
			ps = cnn.prepareStatement(sql);
			ps.setString(1, typeNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				RoomType roomtype=new RoomType();
				roomtype.setTypeNo(rs.getString(1));
				roomtype.setTypeName(rs.getString(2));
				roomtype.setTypeArea(rs.getInt(3));
				roomtype.setTypePrice(rs.getInt(4));
				roomtype.setPeopleNu(rs.getInt(5));
				return roomtype;
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
	public ArrayList<RoomType> getRoomsByPeopleNo(int peopleNo) {
		Connection cnn=DBUtil.openDB();
		String sql="select * from RoomType where PeopleNu=?";
		PreparedStatement ps;
		try {
			ps = cnn.prepareStatement(sql);
			ps.setInt(1, peopleNo);
			ResultSet rs=ps.executeQuery();
			ArrayList<RoomType> roomTypeList=new ArrayList<RoomType>();
			while(rs.next()){
				RoomType roomtype=new RoomType();
				roomtype.setTypeNo(rs.getString(1));
				roomtype.setTypeName(rs.getString(2));
				roomtype.setTypeArea(rs.getInt(3));
				roomtype.setTypePrice(rs.getInt(4));
				roomtype.setPeopleNu(rs.getInt(5));
				roomTypeList.add(roomtype);
			}
			return roomTypeList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		return null;
	}

	@Override
	public ArrayList<RoomType> query() {
		Connection cnn=DBUtil.openDB();
		String sql="select * from RoomType";
		Statement st;
		try {
			st = cnn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			ArrayList<RoomType> roomTypeList=new ArrayList<RoomType>();
			while(rs.next()){
				RoomType roomtype=new RoomType();
				roomtype.setTypeNo(rs.getString(1));
				roomtype.setTypeName(rs.getString(2));
				roomtype.setTypeArea(rs.getInt(3));
				roomtype.setTypePrice(rs.getInt(4));
				roomtype.setPeopleNu(rs.getInt(5));
				roomTypeList.add(roomtype);
			}
			return roomTypeList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		return null;
	}

	@Override
	public void update(RoomType rt) {
		Connection cnn=DBUtil.openDB();
		String sql="update RoomType set TypeName=?,TypeArea=?,TypePrice=?,PeopleNu=? where TypeNo=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, rt.getTypeName());
			ps.setInt(2,rt.getTypeArea());
			ps.setInt(3, rt.getTypePrice());
			ps.setInt(4, rt.getPeopleNu());
			ps.setString(5, rt.getTypeNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
	}

	@Override
	public int getRoomPriceByTypeNo(String typeNo) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select typePrice from roomtype where typeno=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, typeNo);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
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
