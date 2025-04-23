package assignment9;

import java.awt.Color;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		respawn();
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	
	public void respawn() {
        Random rand = new Random();
        x = 0.05 + (0.9 * rand.nextDouble());  // keeping it away from the edges
        y = 0.05 + (0.9 * rand.nextDouble());
    }

    public double getX() { return x; }
    public double getY() { return y; }
}
