package ObjectClass;

import java.util.List;

public interface HouseNewsDao {
	public int add(HouseNews houseNews);
	public int updateByNewsNo(HouseNews houseNews);
	public int deleteByNewsNo(String newsNo);
	public List<HouseNews> query();

}
