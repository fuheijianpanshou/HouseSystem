package ObjectClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseBillDaoImp implements HouseBillDao{

	@Override
	public int add(HouseBill houseBill) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="insert into housebill(BillNo,BillKind,CuNo,UserNo,Year,Month,Day,profit)values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, houseBill.getBillNo());
			preparedStatement.setString(2, houseBill.getBillKind());
			preparedStatement.setString(3, houseBill.getCuNo());
			preparedStatement.setInt(4, Integer.parseInt(houseBill.getUserNo()));
			preparedStatement.setString(5, houseBill.getYear());
			preparedStatement.setString(6, houseBill.getMonth());
			preparedStatement.setString(7, houseBill.getDay());
			preparedStatement.setInt(8, houseBill.getProfit());
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
	public List<HouseBill> getBillByYear(String year) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select * from houseBill where year=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, year);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<HouseBill> houseBills=new ArrayList<>();
			while(resultSet.next()) {
				HouseBill houseBill=new HouseBill();
				houseBill.setBillNo(resultSet.getString(1));
				houseBill.setBillKind(resultSet.getString(2));
				houseBill.setCuNo(resultSet.getString(3));
				houseBill.setUserNo(resultSet.getString(4));
				houseBill.setYear(resultSet.getString(5));
				houseBill.setMonth(resultSet.getString(6));
				houseBill.setDay(resultSet.getString(7));;
				houseBill.setProfit(resultSet.getInt(8));
				houseBills.add(houseBill);
			}
			return houseBills;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		
		return null;
	}

	@Override
	public List<HouseBill> getBillByMonth(String year,String month) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select * from houseBill where month=? and year=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, month);
			preparedStatement.setString(2,year);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<HouseBill> houseBills=new ArrayList<>();
			while(resultSet.next()) {
				HouseBill houseBill=new HouseBill();
				houseBill.setBillNo(resultSet.getString(1));
				houseBill.setBillKind(resultSet.getString(2));
				houseBill.setCuNo(resultSet.getString(3));
				houseBill.setUserNo(resultSet.getString(4));
				houseBill.setYear(resultSet.getString(5));
				houseBill.setMonth(resultSet.getString(6));
				houseBill.setDay(resultSet.getString(7));;
				houseBill.setProfit(resultSet.getInt(8));
				houseBills.add(houseBill);
			}
			return houseBills;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		return null;
	}

	@Override
	public List<HouseBill> getBillByDay(String year,String month,String day) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select * from houseBill where day=? and month=? and year=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, day);
			preparedStatement.setString(2, month);
			preparedStatement.setString(3, year);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<HouseBill> houseBills=new ArrayList<>();
			while(resultSet.next()) {
				HouseBill houseBill=new HouseBill();
				houseBill.setBillNo(resultSet.getString(1));
				houseBill.setBillKind(resultSet.getString(2));
				houseBill.setCuNo(resultSet.getString(3));
				houseBill.setUserNo(resultSet.getString(4));
				houseBill.setYear(resultSet.getString(5));
				houseBill.setMonth(resultSet.getString(6));
				houseBill.setDay(resultSet.getString(7));;
				houseBill.setProfit(resultSet.getInt(8));
				houseBills.add(houseBill);
			}
			return houseBills;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		return null;
	}
	
	public static void main(String[] arg) {
		HouseBillDaoImp houseBillDaoImp=new HouseBillDaoImp();
		HouseBill houseBill=new HouseBill();
		houseBill.setBillNo("2323");
		houseBill.setBillKind("444");
		houseBill.setCuNo("1245");
		houseBill.setDay("2");
		houseBill.setMonth("5");
		houseBill.setYear("5");
		houseBill.setProfit(5);
		houseBill.setUserNo("1");
		houseBillDaoImp.add(houseBill);
	}

}
