package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RenderGame extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Snake snake = SnakeRunner.snake;
		Cherry cherry = SnakeRunner.cherry;
		String endStr = "Game Over!";
		String score;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 750, 700);
		
		g.setColor(Color.WHITE);
		
		for (Point point : snake.body) {
			g.fillOval(point.x * snake.SCALE, point.y * snake.SCALE, snake.SCALE, snake.SCALE);
		}
		g.setColor(Color.GREEN);
		g.fillOval(snake.head.x * snake.SCALE, snake.head.y * snake.SCALE, snake.SCALE, snake.SCALE);
		
		g.setColor(Color.RED);
		g.fillOval(cherry.cherry.x * snake.SCALE, cherry.cherry.y * snake.SCALE, 15, 15);
		
		g.setColor(Color.WHITE);
		
		score = "Score: " + (SnakeRunner.tailLength - 1); 
		g.drawString(score, (int) (getWidth() / 2 - score.length() * 2.5f), 10);
		
		if (SnakeRunner.isGameOver){
			g.drawString(endStr, (int) (getWidth() / 2 - endStr.length() * 2.5f), (int) SnakeRunner.dim.getHeight() / 4);
		}
	}
}
