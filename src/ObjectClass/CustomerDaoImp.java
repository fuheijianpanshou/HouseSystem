package ObjectClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;






public class CustomerDaoImp implements CustomerDao{
	public void add(Customer cu){
		Connection cnn=DBUtil.openDB();
		String sql="insert into customer(CuNo,CuCard,CuName,CuSex,CuPhone,CuPay,RoomNo,CuReserveTime,ReserveTimeLong)values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, cu.getCuNo());
			ps.setString(2, cu.getCuCard());
			ps.setString(3, cu.getCuName());
			ps.setString(4, cu.getCuSex());
			ps.setString(5,cu.getCuPhone());
			ps.setString(6, cu.getCuPay());
			ps.setString(7, cu.getCuRoomNo());
			ps.setString(8, cu.getCuReserveTime());
			ps.setInt(9, cu.getReserveTimeLong());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
		
	}
	
	
	public int deleteByCuNo(String cardNo){
		Connection cnn=DBUtil.openDB();
		String sql="delete from customer where Cuno=?";
		PreparedStatement ps;
		try {
			ps = cnn.prepareStatement(sql);
			ps.setString(1, cardNo);
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
	public void update(Customer cu){
		Connection cnn=DBUtil.openDB();
		String sql="update customer set CuCard=?,CuName=?,CuSex=?,CuPhone=?,cuPay=? where CuNo=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, cu.getCuCard());
			ps.setString(2, cu.getCuName());
			ps.setString(3, cu.getCuSex());
			ps.setString(4,cu.getCuPhone());
			ps.setString(5, cu.getCuPay());
			ps.setString(6, cu.getCuNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
		
	}
	
	public void updateCuPayByCuPhone(String phone,String payStatus) {
		Connection cnn=DBUtil.openDB();
		String sql="update customer set CuPay=? where CuPhone=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, payStatus);
			ps.setString(2, phone);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(cnn);
		}
		
	}
	
	/*public void deleteByCuName(String cuName){
		Connection cnn=DBUtil.openDB();
		String sql="delete from customer where CuName=?";
		PreparedStatement ps;
		try {
			ps = cnn.prepareStatement(sql);
			ps.setString(1, cuName);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
		
	}*/
	
	public void deleteByCuPhone(String phoneNo){
		Connection cnn=DBUtil.openDB();
		String sql="delete from customer where CuPhone=?";
		PreparedStatement ps;
		try {
			ps = cnn.prepareStatement(sql);
			ps.setString(1, phoneNo);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
	}
	
	public Customer getCustomerByCuCard(String cardNo){
		Connection cnn=DBUtil.openDB();
		String sql="select * from customer where CuCard=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, cardNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Customer cu=new Customer();
				cu.setCuNo(rs.getString(1));
				cu.setCuName(rs.getString(3));
				cu.setCuCard(rs.getString(2));
				cu.setCuPhone(rs.getString(5));
				cu.setCuSex(rs.getString(4));
				cu.setCuPay(rs.getString(6));
				cu.setCuRoomNo(rs.getString(7));
				return cu;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		
		return null;
	}
	
	public Customer getCustomerByCuPhone(String phoneNo){
		Connection cnn=DBUtil.openDB();
		String sql="select * from customer where CuPhone=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, phoneNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Customer cu=new Customer();
				cu.setCuNo(rs.getString(1));
				cu.setCuName(rs.getString(3));
				cu.setCuCard(rs.getString(2));
				cu.setCuPhone(rs.getString(5));
				cu.setCuSex(rs.getString(4));
				cu.setCuPay(rs.getString(6));
				cu.setCuRoomNo(rs.getString(7));
				cu.setPastCuRoomNo(rs.getString(8));
				cu.setReserveTimeLong(rs.getInt(11));
				return cu;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		return null;
	}
	
	public ArrayList<Customer> getCustomerByName(String name){
		Connection cnn=DBUtil.openDB();
		String sql="select * from customer where CuName=?";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ArrayList<Customer> customerList=new ArrayList<Customer>();
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Customer cu=new Customer();
				cu.setCuNo(rs.getString(1));
				cu.setCuName(rs.getString(3));
				cu.setCuCard(rs.getString(2));
				cu.setCuPhone(rs.getString(5));
				cu.setCuSex(rs.getString(4));
				cu.setCuPay(rs.getString(6));
				cu.setCuRoomNo(rs.getString(7));
				customerList.add(cu);
			}
			return customerList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		return null;
	}
	
	public ArrayList<Customer> query(){
		Connection cnn=DBUtil.openDB();
		String sql="select * from customer";
		try {
			Statement st=cnn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			ArrayList<Customer> cuList=new ArrayList<Customer>();
			while(rs.next()){
				Customer cu=new Customer();
				cu.setCuNo(rs.getString(1));
				cu.setCuName(rs.getString(3));
				cu.setCuCard(rs.getString(2));
				cu.setCuPhone(rs.getString(5));
				cu.setCuSex(rs.getString(4));
				cu.setCuPay(rs.getString(6));
				cu.setCuRoomNo(rs.getString(7));
				cuList.add(cu);
			}
			return cuList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(cnn);
		}
		return null;
	}


	@Override
	public void swapRoomByCuPhone(String phone, String roomNo) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.openDB();
		String sql="update customer set roomno=? where cuphone=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, roomNo);
			preparedStatement.setString(2, phone);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(connection);
		}
		
	}
	



@Override
public Customer getCustomerByCuNo(String cuNO) {
	// TODO Auto-generated method stub
	Connection connection=DBUtil.openDB();
	String sql="select * from Customer where cuno=?";
	try {
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1, cuNO);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			Customer cu=new Customer();
			cu.setCuNo(rs.getString(1));
			cu.setCuName(rs.getString(3));
			cu.setCuCard(rs.getString(2));
			cu.setCuPhone(rs.getString(5));
			cu.setCuSex(rs.getString(4));
			cu.setCuPay(rs.getString(6));
			cu.setCuRoomNo(rs.getString(7));
			cu.setCuReserveTime(rs.getString(9));
			cu.setReserveTimeLong(rs.getInt(11));
			return cu;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DBUtil.closeDB(connection);
	}
	
	return null;
}
public static void main(String[] arg) {
	CustomerDaoImp customerDaoImp=new CustomerDaoImp();
	Customer customer=new Customer();
	customer=customerDaoImp.getCustomerByCuNo("6317");
	System.out.println(customer.getCuName());
}


@Override
public String getRoomNoByCuNo(String cuNo) {
	// TODO Auto-generated method stub
	Connection connection=DBUtil.openDB();
	String sql="select roomNo from customer where cuno=?";
	try {
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, cuNo);
		ResultSet resultSet=preparedStatement.executeQuery();
		if (resultSet.next()) {
			String roomNo=resultSet.getString(1);
			return roomNo;
			
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
public String getRoomNoByCuPhone(String phone) {
	// TODO Auto-generated method stub
	Connection connection=DBUtil.openDB();
	String sql="select roomNo from customer where cuphone=?";
	try {
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, phone);
		ResultSet resultSet=preparedStatement.executeQuery();
		if (resultSet.next()) {
			String roomNo=resultSet.getString(1);
			return roomNo;
			
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
public void updateCuPayByCuNo(String cuNo, String payStatus) {
	// TODO Auto-generated method stub
	Connection cnn=DBUtil.openDB();
	String sql="update customer set CuPay=? where CuNo=?";
	try {
		PreparedStatement ps=cnn.prepareStatement(sql);
		ps.setString(1, payStatus);
		ps.setString(2, cuNo);
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DBUtil.closeDB(cnn);
	}
	
}


@Override
public String getPayStatusByCuNo(String cuNo) {
	// TODO Auto-generated method stub
	Connection connection=DBUtil.openDB();
	String sql="select CuPay from customer where cuNo=?";
	try {
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, cuNo);
		ResultSet resultSet=preparedStatement.executeQuery();
		if (resultSet.next()) {
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
public String getPayStatusByCuPhone(String phone) {
	// TODO Auto-generated method stub
	Connection connection=DBUtil.openDB();
	String sql="select CuPay from customer where cuphone=?";
	try {
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, phone);
		ResultSet resultSet=preparedStatement.executeQuery();
		if (resultSet.next()) {
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
public int getTimeLongByPhone(String phone) {
	// TODO Auto-generated method stub
	Connection connection=DBUtil.openDB();
	String sql="select reserveTimeLong from customer where cuphone=?";
	try {
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, phone);
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


@Override
public void addCheckCustomer(Customer cu) {
	// TODO Auto-generated method stub
	Connection cnn=DBUtil.openDB();
	String sql="insert into customer(CuNo,CuCard,CuName,CuSex,CuPhone,CuPay,RoomNo,cuCheckTime,ReserveTimeLong)values(?,?,?,?,?,?,?,?,?)";
	try {
		PreparedStatement ps=cnn.prepareStatement(sql);
		ps.setString(1, cu.getCuNo());
		ps.setString(2, cu.getCuCard());
		ps.setString(3, cu.getCuName());
		ps.setString(4, cu.getCuSex());
		ps.setString(5,cu.getCuPhone());
		ps.setString(6, cu.getCuPay());
		ps.setString(7, cu.getCuRoomNo());
		ps.setString(8, cu.getCuCheckTime());
		ps.setInt(9, cu.getReserveTimeLong());
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		DBUtil.closeDB(cnn);
	}
	
}


@Override
public String getCuNoByCuPhone(String cuPhone) {
	// TODO Auto-generated method stub
	Connection connection=DBUtil.openDB();
	String sql="select CuNo from Customer where cuPhone=?";
	try {
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, cuPhone);
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
public List<Customer> getCustomerByPayStatus(String payStatus) {
	// TODO Auto-generated method stub
	Connection connection=DBUtil.openDB();
	String sql="select * from customer where cupay=?";
	try {
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, payStatus);
		ResultSet resultSet=preparedStatement.executeQuery();
		List<Customer> customers=new ArrayList<>();
		while(resultSet.next()) {
			Customer customer=new Customer();
			customer.setCuNo(resultSet.getString(1));
			customer.setCuCard(resultSet.getString(2));
			customer.setCuName(resultSet.getString(3));
			customer.setCuSex(resultSet.getString(4));
			customer.setCuPhone(resultSet.getString(5));
			customer.setCuPay(resultSet.getString(6));
			customer.setCuRoomNo(resultSet.getString(7));
			customer.setPastCuRoomNo(resultSet.getString(8));
			customer.setCuReserveTime(resultSet.getString(9));
			customer.setCuCheckTime(resultSet.getString(10));
			customer.setReserveTimeLong(resultSet.getInt(11));
			customers.add(customer);
		}
		return customers;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DBUtil.closeDB(connection);
	}
	return null;
}


@Override
public int updatePastRoomNoByCuNo(String cuNo, String roomNo) {
	// TODO Auto-generated method stub
	Connection connection=DBUtil.openDB();

	String sql2="update room set roomStatus='«Â¿Ì' where roomNo=?";
	try {
		
		PreparedStatement preparedStatement3=connection.prepareStatement(sql2);
		preparedStatement3.setString(1, roomNo);
		int n=preparedStatement3.executeUpdate();
	
		
	
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
