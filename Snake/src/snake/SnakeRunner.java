package snake;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class SnakeRunner implements ActionListener, KeyListener{
	
	public JFrame jframe;
	public static Dimension dim;
	public RenderGame render;
	public int direction;
	public Timer timer = new Timer(20, this);
	public int ticks;
	public static Snake snake;
	public static int tailLength;
	public static Cherry cherry;
	public static boolean isGameOver;
	
	//sets up a blank display for the game
	public SnakeRunner() {
		dim = Toolkit.getDefaultToolkit().getScreenSize();//https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
		jframe = new JFrame("Snake");
		jframe.setSize(750, 700);
		jframe.setLocation(dim.width/2-jframe.getSize().width/2, dim.height/2-jframe.getSize().height/2);
		snake = new Snake();
		cherry = new Cherry();
		jframe.add(render = new RenderGame());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
		jframe.addKeyListener(this);// allows program to take input from user keys
		gameStart();
	}
	public void gameStart() {
		
		isGameOver = false;
		cherry.genNewCherryPos();
		ticks = 0;
		tailLength = 1;
		direction = 1;
		snake.clear();
		snake.reset();
		timer.start();
	}
	public static void main(String[] args) {
		 SnakeRunner snake = new SnakeRunner();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		render.repaint(); //automatically updates the graphics
		ticks++;
		
		if((ticks % 2 == 0) && (snake.getHeadPos() != null) && (isGameOver != true)) {
			snake.addBodyParts();
			
			if (snake.isInBounds(direction)) {
				snake.moveSnake(direction);
			} else {
				isGameOver = true;
			}
			if (snake.body.size() > tailLength) {
				snake.body.remove(0);
			}
		} 
		if ( snake.getHeadPos().equals(cherry.getCherryPos())) {
			tailLength++;
			cherry.genNewCherryPos();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int i = e.getKeyCode();
		//could probably use else if's instead
		if ((i == KeyEvent.VK_A || i == KeyEvent.VK_LEFT) && direction != 3)
		{
			direction = 2;
		}

		if ((i == KeyEvent.VK_D || i == KeyEvent.VK_RIGHT) && direction != 2)
		{
			direction = 3;
		}

		if ((i == KeyEvent.VK_W || i == KeyEvent.VK_UP) && direction != 1)
		{
			direction = 0;
		}

		if ((i == KeyEvent.VK_S || i == KeyEvent.VK_DOWN) && direction != 0)
		{
			direction = 1;
		}
		if (i == KeyEvent.VK_SPACE) {
			if (isGameOver == true) {
				gameStart();
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}

