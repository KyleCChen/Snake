package snake;

import java.awt.Point;
import java.util.ArrayList;

public class Snake {
	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
	public static final int SCALE = 10;
	//specific points of each part of the snake
	public static ArrayList<Point> body = new ArrayList<Point>();
	// point with x and y coordinates of the head, also sets the initial starting pos at x = 25, y = 25
	public Point head = new Point(25, 25);
	
	//changes the x and y pos of the head Point object based on the direction its facing
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
	
	//adds a body part to the body arraylist 
	public void addBodyParts() {
		body.add(new Point(head.x, head.y));
	}
	public Point getHeadPos() {
		return head;
	}
	//clears the body arraylist, cause im lazy like that
	public void clear() {
		body.clear();
	}
	//sets the head pos at the initial starting position, mostly for restarting the game and when you lose
	public void reset() {
		head = new Point(25, 25);
	}
	//checks if the head overlaps/runs into the tail
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
	//checks if the head goes outside of the panel/screen boundaries
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
