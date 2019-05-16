package ObjectClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao{

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		Connection cnn=DBUtil.openDB();
		String sql="insert into User(UserName,UserPhone,UserAdress,UserPassword,UserSex,UserPosition) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPhone());
			ps.setString(3, user.getUserAdress());
			ps.setString(4, user.getUserPassword());
			ps.setString(5, user.getUserSex());
			ps.setString(6, user.getUserPosition());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(cnn);
		}
		
	}

	@Override
	public void delete(int userNo) {
		// TODO Auto-generated method stub
		Connection cnn=DBUtil.openDB();
		String sql="delete from User where userNo=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setInt(1, userNo);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(cnn);
		}
		
	}

	@Override
	public ArrayList<User> query() {
		// TODO Auto-generated method stub
		Connection cnn=DBUtil.openDB();
		String sql="select * from User";
		try {
			Statement st=cnn.createStatement();
			ArrayList<User> userList=new ArrayList<>();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				User user=new User();
				user.setUserNo(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPhone(rs.getString(3));
				user.setUserAdress(rs.getString(4));
				user.setUserSex(rs.getString(5));
				user.setUserPosition(rs.getString(6));
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(cnn);
		}
		
		
		return null;
	}
	public static void main(String[] arg) {
		UserDaoImp userDaoImp=new UserDaoImp();
		User user=new User();
		user.setUserName("兰伟华");
		user.setUserAdress("济南大写");
		user.setUserPassword("123456");
		user.setUserPhone("15254150050");
		user.setUserPosition("管理员");
		user.setUserSex("男");
		userDaoImp.add(user);
	}

	@Override
	public String queryByUserNo(int userNo) {
		// TODO Auto-generated method stub
		String password=null;
		Connection connection=DBUtil.openDB();
		String sql="select userpassword from user where userNo=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, userNo);
			ResultSet rSet=preparedStatement.executeQuery();
			while(rSet.next()) {
				password=rSet.getString(1);
			}
			return password;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		return null;
	}

	@Override
	public User queryUserByUserNo(int userNo) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select * from user where userNo=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, userNo);
			ResultSet rSet=preparedStatement.executeQuery();
			User user=new User();
			while(rSet.next()) {
				user.setUserNo(rSet.getInt(1));
				user.setUserName(rSet.getString(2));
				user.setUserPhone(rSet.getString(3));
				user.setUserAdress(rSet.getString(4));
				user.setUserPassword(rSet.getString(5));
				user.setUserSex(rSet.getString(6));
				user.setUserPosition(rSet.getString(7));
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
}
