package ObjectClass;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil {
	private static String user;
	private static String password;
	private static String url;
	private static String driver;
	static{
		Properties pro=new Properties();
		try {
			Reader reader=new FileReader("src\\databaseconfig.properties");
			pro.load(reader);
			user=pro.getProperty("user");
			password=pro.getProperty("password");
			url=pro.getProperty("url");
			driver=pro.getProperty("driver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection openDB(){
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	public static void closeDB(Connection cnn){
		if(cnn!=null){
			try {
		
			
				cnn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	

}
