package snake;

import java.awt.Point;
import java.util.Random;

public class Cherry {
	public Point cherry;
	public Random r;
	
	public Cherry() {
		r = new Random();
	}
	public Point getCherryPos() {
		return cherry;
	}
	public void genNewCherryPos() {
		cherry = new Point(r.nextInt(70) + 1, r.nextInt(62) + 1);
	}
}
