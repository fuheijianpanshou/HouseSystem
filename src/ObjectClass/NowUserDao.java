package ObjectClass;


public interface NowUserDao {

	public int add(NowUser nowUser);
	public int updateByhouseNO(String houseNo,String userNo);
	public String getUserByHouseNo(String houseNo);
}
