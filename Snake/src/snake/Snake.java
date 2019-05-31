package snake;

import java.awt.Point;
import java.util.ArrayList;

public class Snake {
	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
	public static final int SCALE = 10;
	public static ArrayList<Point> body = new ArrayList<Point>();
	public Point head;

	public Snake() {
		head = new Point(25, 25);
	}
	
	public void moveSnake(int direction) {
		if (direction == UP) {
			head = new Point(head.x, head.y - 1);
		} else if (direction == DOWN) {
			head = new Point(head.x, head.y + 1);
		} else if(direction == LEFT) {
			head = new Point(head.x - 1, head.y);
		} else {
			head = new Point(head.x + 1, head.y);
		}
	}
	
	public void addBodyParts() {
		body.add(new Point(head.x, head.y));
	}
	public Point getHeadPos() {
		return head;
	}
	
	public void clear() {
		body.clear();
	}
	public void reset() {
		head = new Point(25, 25);
	}
	public boolean noTailAt(int x, int y)
	{
		for (Point point : body)
		{
			if (point.equals(new Point(x, y)))
			{
				return false;
			}
		}
		return true;
	}
	public boolean isInBounds(int direction) {
		if (direction == UP && head.y - 1 >= 0 && noTailAt(head.x, head.y - 1)) {
			return true;
		} else if (direction == DOWN && head.y + 2 < 67 && noTailAt(head.x, head.y + 1)) {
			return true;
		} else if (direction == LEFT && head.x - 1 >= 0 && noTailAt(head.x - 1, head.y)) {
			return true;
		} else if (direction == RIGHT && head.x + 2 < 74 && noTailAt(head.x + 1, head.y)){
			return true;
		}
		return false;
	}
  }
