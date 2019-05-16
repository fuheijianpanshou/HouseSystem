package ObjectClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NowUserDaoImp implements NowUserDao{

	@Override
	public int add(NowUser nowUser) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="insert into nowuser(houseno,userno)values(?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, nowUser.getHouseNo());
			preparedStatement.setString(2, nowUser.getUserNo());
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
	public int updateByhouseNO(String houseNo,String userNo) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="update nowuser set userno=? where houseno=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userNo);
			preparedStatement.setString(2, houseNo);
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
	public String getUserByHouseNo(String houseNo) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select userno from nowuser where houseno=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, houseNo);
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

}
