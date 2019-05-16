package ObjectClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class MessageDaoImp implements MessageDao{

	@Override
	public int add(Message message) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="insert into Message(Time,Content)values(?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, message.getTime());
			preparedStatement.setString(2, message.getContent());
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
	public List<Message> query() {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select * from Message";
		try {
			java.sql.Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			List<Message> messages=new ArrayList<>();
			while(resultSet.next()) {
				Message message=new Message();
				message.setTime(resultSet.getString(1));
				message.setContent(resultSet.getString(2));
				messages.add(message);
			}
			return messages;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
