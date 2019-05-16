package ObjectClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PastCustomerDaoImp implements PastCustomerDao{

	@Override
	public int add(Customer customer) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="insert into pastcustomer(cuno,cucard,cuname,cusex,cuphone,roomno)values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getCuNo());
			preparedStatement.setString(2, customer.getCuCard());
			preparedStatement.setString(3, customer.getCuName());
			preparedStatement.setString(4, customer.getCuSex());
			preparedStatement.setString(5, customer.getCuPhone());
			preparedStatement.setString(6, customer.getCuRoomNo());
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
	public List<PastCustomer> getPastCustomerByPhone(String phone) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="select * from pastcustomer where cuphone=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, phone);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<PastCustomer> pastCustomers=new ArrayList<>();
			while(resultSet.next()) {
				PastCustomer pastCustomer=new PastCustomer();
				pastCustomer.setCuNo(resultSet.getString(1));
				pastCustomer.setCuCard(resultSet.getString(2));
				pastCustomer.setCuName(resultSet.getString(3));
				pastCustomer.setCuSex(resultSet.getString(4));
				pastCustomer.setCuPhone(resultSet.getString(5));
				pastCustomer.setCuRoomNo(resultSet.getString(6));
				pastCustomers.add(pastCustomer);
			}
			return pastCustomers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		
		return null;
	}

}
