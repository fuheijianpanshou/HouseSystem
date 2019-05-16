package ObjectClass;

import java.util.List;

public interface PastCustomerDao {
	public int add(Customer customer);
	public List<PastCustomer> getPastCustomerByPhone(String phone);

}
