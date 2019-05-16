package ObjectClass;

import java.util.List;

public interface OutedRoomThingDao {
	
	public void add(OutedRoomThing outedRoomThing);
	public List<OutedRoomThing> getOutedRoomThingsByCuNoAndRoomNo(String cuNO,String roomNo);
	public int deleteByCuNo(String cuNo);
	

}
