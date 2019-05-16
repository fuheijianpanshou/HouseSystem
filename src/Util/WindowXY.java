package Util;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;


public class WindowXY {
	public static Point getPoint(Dimension di) {
		//System.out.println("!!!!!!!!!!!!!!");
		Toolkit to=Toolkit.getDefaultToolkit();
		int width=to.getScreenSize().width;
		int hight=to.getScreenSize().height;
		return new Point((width-(int)di.getWidth())/2,(hight-(int)di.getHeight())/2);
	}

}
