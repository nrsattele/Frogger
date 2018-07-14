import javax.swing.*;
import java.awt.*;

/*
 * Frog adds additional implementation to MovingRectangle unique to the frog
 * including direction, turning, and collision checking.
 */
class Frog extends MovingRectangle {
	// Constants
	private final double SPEED = 65;

	// Direction information
	private int startingDirection;
	private int direction;

	// Game Board Size
	private int minX, minY, maxX, maxY;

	// Images
	private ImageIcon left, right, up, down, explosion;

	public Frog(int x1, int y1, int direction1, int minX1, int minY1, int maxX1, int maxY1) {

		super.width = 50;
		super.length = 50;
		super.startingX = x = x1;
		super.startingY = y = y1;

		direction = direction1;
		startingDirection = direction;

		minX = minX1;
		minY = minY1;
		maxX = maxX1;
		maxY = maxY1;

		// Initalizes icons for each orientation of the frog in addition to the
		// explosinon when it collides with something
		left = new ImageIcon("assets/FrogL.png");
		right = new ImageIcon("assets/FrogR.png");
		up = new ImageIcon("assets/FrogUp.png");
		down = new ImageIcon("assets/FrogD.png");
		explosion = new ImageIcon("assets/explosion.png");
	}

	// Getter methods
	public double getSpeed() {
		return SPEED;
	}

	public int getDirection() {
		return direction;
	}

	// Turning methods
	public void turnLeft() {
		setDirection(270);
		this.move();
	}

	public void turnRight() {
		setDirection(90);
		this.move();
	}

	public void turnUp() {
		setDirection(0);
		this.move();
	}

	public void turnDown() {
		setDirection(180);
		this.move();
	}

	private void setDirection(int newDir) {
		direction = newDir;
		if (direction != 0 && direction != 90 && direction != 180 && direction != 270)
			direction = 0;
	}

	// Draws the frog in the correct location and orientation
	public void draw(myJFrame frame, Graphics g) {
		// Sets correct frog image based off direction
		ImageIcon toUse = up;
		if (direction == 90)
			toUse = right;
		if (direction == 180)
			toUse = down;
		if (direction == 270)
			toUse = left;

		g.drawImage(toUse.getImage(), (int)x - width / 2, (int)y - length / 2, width, length, frame);
	}

	// Draws an explosion at the position of the frog when it collides
	public void drawExplosion(Frame frame, Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x - width / 2, (int)y - length / 2, width, length);
		g.drawImage(explosion.getImage(), (int)x - width / 2, (int)y - length / 2, width, length, frame);
	}

	// Moves the frog based on its direction
	public void move() {
		// checks direction
		if (getDirection() == 0 && (y - length / 2 > minY))
			y -= 65;
		if (getDirection() == 180 && (y + length / 2 < maxY))
			y += 65;
		if (getDirection() == 90 && (x + width / 2 < maxX))
			x += 65;
		if (getDirection() == 270 && (x - width / 2 > minX))
			x -= 65;
	}

	/*
	 * FrogMove is used to move the frog in the x direction based on a speed. Used
	 * to move the frog with the log when it is floating
	 */
	public void frogMove(double speed) {
		x += speed;
	}

	// Checks to see if the frog is colliding with a moving rectangle
	public boolean isColliding(MovingRectangle t) {
		return Math.abs((int)x - t.getX()) <= width && Math.abs((int)y - t.getY()) <= length;
	}

	// Checks to see if the frog is in the river (on a log or drowning)
	public boolean isInRiver() {
		return (y < 267 && y > 72);
	}

	// Checks to see if the frog is going off the map
	public boolean isTouchingSide() {
		if (((int)x - width / 2 <= minX && direction == 270) || ((int)x + width / 2 >= maxX && direction == 90)
				|| ((int)y - length / 2 <= minY && direction == 0) || ((int)y + length / 2 >= maxY && direction == 180))
			return true;
		return false;
	}

	// Reset
	public void reset() {
		super.reset();
		direction = startingDirection;
	}

}
