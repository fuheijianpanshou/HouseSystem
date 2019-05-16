package ObjectClass;
import java.util.ArrayList;
import java.util.List;

public interface UserDao {

	public void add(User user);
	public String queryByUserNo(int userNo);
	public User queryUserByUserNo(int userNo);
	public void delete(int userNo);
	public ArrayList<User> query();	
}
