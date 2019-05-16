package ObjectClass;

import java.util.List;

public interface MessageDao {

	public int add(Message message);
	public List<Message> query();
}
