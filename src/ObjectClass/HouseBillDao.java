package ObjectClass;

import java.util.List;

public interface HouseBillDao {

	public int add(HouseBill houseBill);
	public List<HouseBill> getBillByYear(String year);
	public List<HouseBill> getBillByMonth(String year,String month);
	public List<HouseBill> getBillByDay(String year,String month,String day);
	
}
