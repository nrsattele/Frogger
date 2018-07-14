import java.awt.Graphics;
import javax.swing.ImageIcon;

/*
 * Moving obstacle provides the implementation of basic moving rectangles that
 * can change their position (x,y) based on a fixed speed and direction in the
 * positive x direction and be reset to a starting position.
 */
class MovingObstacle extends MovingRectangle {

	// Static variable used to describe the speed of ALL Moving Rectangles (cars, logs)
	// Increased after each level up
	public static double speed = 0.5;

	// Game Board Size to determine when moving rectangle is out of frame
	private int maxX;

	// Image to use
	private ImageIcon icon;

	/**
	 * Initalizes private variables
	 */
	public MovingObstacle(int x1, int y1, int maxX1, int w1, int l1, String iconName) {
		super.width = w1;
		super.length = l1;
		super.startingX = x = x1;
		super.startingY = y = y1;
		maxX = maxX1;
		icon = new ImageIcon(iconName);
	}

	public double getSpeed() {
		return speed;
	}

	// setX used to change the position of the moving rectangle
	public void setX(int a) {
		x = a;
	}

	// Drawing
	public void draw(myJFrame frame, Graphics g) {
		g.drawImage(icon.getImage(), getX() - width / 2, getY() - length / 2, width, length, frame);
	}

	// Move increases the x value of the obstacle by the value of speed
	public void move() {
		// checks edge of screen
		if (x + width / 2 < maxX)
			x += speed;
	}
}