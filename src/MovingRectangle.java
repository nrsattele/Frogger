import java.awt.Graphics;

/*
 * MovingRectangle defines the common implementation between all moving objects
 * (cars, logs, frogs)
 */
public abstract class MovingRectangle {

	// Constraints
	protected int width;
	protected int length;

	// Starting Information for reset method
	protected double startingX, startingY;

	// Coordinates
	protected double x, y;

	// Getter methods
	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	public abstract double getSpeed();

	// Draws the rectangle
	public abstract void draw(myJFrame frame, Graphics g);

	// Moves the rectangle across the screen
	public abstract void move();

	// Resets the rectangle to its inital coordinates
	public void reset() {
		x = startingX;
		y = startingY;
	}
}