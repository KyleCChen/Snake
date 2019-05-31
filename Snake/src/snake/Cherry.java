package snake;

import java.awt.Point;
import java.util.Random;

public class Cherry {
	public Point cherry;
	public Random r = new Random();

	// returns the cherry point object
	public Point getCherryPos() {
		return cherry;
	}
	//creates a new random position for the cherry to be rendered at
	public void genNewCherryPos() {
		cherry = new Point(r.nextInt(70) + 1, r.nextInt(62) + 1);
	}
}
