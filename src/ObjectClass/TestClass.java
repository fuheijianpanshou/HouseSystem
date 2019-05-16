package ObjectClass;
import java.util.ArrayList;


public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RoomType rt=new RoomType();
		RoomTypeDao rtd=new RoomTypeDaoImp();
		rt.setTypeNo("1");
		rt.setPeopleNu(2);
		//rt.setTypeArea("30");
		rt.setTypePrice(160);
		rt.setTypeName("Ë«ÈË¼ä");
		//rtd.add(rt);
		//rtd.delete("10");
		//rt=rtd.getRoomByTypeNo("1");
		/*ArrayList<RoomType> rList=new ArrayList<RoomType>();
		rList=rtd.query();
		rt=rList.get(0);
		System.out.println(rt.getTypeName());*/
		rtd.add(rt);
	}

}
