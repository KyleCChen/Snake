package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RenderGame extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//creates a new reference to the snake and cherry objects in the SnakeRunner class
		Snake snake = SnakeRunner.snake;
		Cherry cherry = SnakeRunner.cherry;
		
		//text to be displayed during the game
		String endStr = "GAME OVER!";
		String score;
		
		//"paints" background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 750, 700);
		
		//retrieves the arrayList that stores the individual parts of the snake from the snake class
		//uses a for each loop to draw a circle at the specified x and y coordinates of each point object, for each one in the array 
		g.setColor(Color.WHITE);
		for (Point point : snake.body) {
			g.fillOval(point.x * snake.SCALE, point.y * snake.SCALE, snake.SCALE, snake.SCALE);
		}
		//draws the head at the x and y specified for the head of the snake
		g.setColor(Color.GREEN);
		g.fillOval(snake.head.x * snake.SCALE, snake.head.y * snake.SCALE, snake.SCALE, snake.SCALE);
		
		//draws a cherry at the specified x and y coordinates, which are randomly generated in the cherry class
		g.setColor(Color.RED);
		g.fillOval(cherry.cherry.x * snake.SCALE, cherry.cherry.y * snake.SCALE, 15, 15);
		
		//prints text for the score and the game over text;
		g.setColor(Color.WHITE);
		
		score = "Score: " + (SnakeRunner.tailLength - 1); 
		g.drawString(score, (int) (getWidth() / 2 - score.length() * 2.5f), 10);
		
		if (SnakeRunner.isGameOver){
			g.drawString(endStr, (int) (getWidth() / 2 - endStr.length() * 2.5f), (int) SnakeRunner.dim.getHeight() / 4);
			g.drawString("PRESS SPACE TO CONTINUE..", ((int) (getWidth() / 2 - endStr.length() * 2.5f) - 45), (int) (SnakeRunner.dim.getHeight() / 4) + 15);
		}
	}
}
