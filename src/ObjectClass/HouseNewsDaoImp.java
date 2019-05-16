package ObjectClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class HouseNewsDaoImp implements HouseNewsDao{

	@Override
	public int add(HouseNews houseNews) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="insert into HouseNews(newsNo,newsshowtime,newskinds,newscontent)values(?,?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, houseNews.getNewsNo());
			preparedStatement.setString(2, houseNews.getNewsShowTime());
			preparedStatement.setString(3, houseNews.getNewsKinds());
			preparedStatement.setString(4, houseNews.getNewsContent());
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
	public int updateByNewsNo(HouseNews houseNews) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="update housenews set newsshowtime=?,newskinds=?,newscontent=? where newsno=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, houseNews.getNewsShowTime());
			preparedStatement.setString(2, houseNews.getNewsKinds());
			preparedStatement.setString(3, houseNews.getNewsContent());
			preparedStatement.setString(4, houseNews.getNewsNo());
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
	public int deleteByNewsNo(String newsNo) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="delete from housenews where newsno=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, newsNo);
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
	public List<HouseNews> query() {
		// TODO Auto-generated method stub
		Connection  connection=DBUtil.openDB();
		String sql="select * from housenews";
		try {
			java.sql.Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			List<HouseNews> houseNewsList=new ArrayList<>();
			while(resultSet.next()) {
				HouseNews houseNews=new HouseNews();
				houseNews.setNewsNo(resultSet.getString(1));
				houseNews.setNewsShowTime(resultSet.getString(2));
				houseNews.setNewsKinds(resultSet.getString(3));
				houseNews.setNewsContent(resultSet.getString(4));
				houseNewsList.add(houseNews);
				
			}
			return houseNewsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		return null;
	}

}
