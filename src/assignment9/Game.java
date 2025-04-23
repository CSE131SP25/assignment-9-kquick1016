package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
    private Food food;
    
	public Game() {
		StdDraw.setCanvasSize(600, 600);
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		StdDraw.enableDoubleBuffering();

		snake = new Snake();
		food = new Food();
	}
	
	public void play() {
		while (snake.isInbounds()) {
            int dir = getKeypress();
            //System.out.println("Keypress: " + dir);
            if (dir != -1) {
                snake.changeDirection(dir);
            		}
            snake.move();
            
            if (snake.eatFood(food)) {
                food.respawn();
            		}
            updateDrawing(); 
				}
		
			// Game Over message
			StdDraw.clear();
			StdDraw.setPenColor(Color.RED);
        	StdDraw.text(0.5, 0.5, "Game Over!");
        	StdDraw.show();
		    }
	
            
		/**while (true) { //TODO: Update this condition to check if snake is in bounds
			
			//Testing only: you will eventually need to do more work here
			System.out.println("Keypress: " + dir);
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
		
	
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
        snake.draw();
        food.draw();
        StdDraw.show();
        StdDraw.pause(100);
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
