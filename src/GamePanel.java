import javax.swing.*;
import java.awt.*;
import java.util.*;

/*
 * myJPanel controls most of the game logic including all communication between
 * cars, logs, and the frog including their initalization
 */
class myJPanel extends JPanel {
	// Keeps track of arrow key being hit
	private KeyList KL;

	// the frame used
	private myJFrame frame;

	// Game header (includes score, level, title)
	private TextPanel txtPanel;

	// All objects in the game
	private Frog myFrog;
	private ArrayList<Car> myCars;
	private ArrayList<Log> myLogs;

	// Holds value of current level
	private int level;

	// Boolean switches during levelUp events
	private boolean levelUp;

	public myJPanel(TextPanel txtPanel1, KeyList KL1, myJFrame frame1) {
		levelUp = false;
		level = 1;
		KL = KL1;
		frame = frame1;
		txtPanel = txtPanel1;
		setBackground(Color.black);

		// ArrayList keeps track of the logs and cars on the gameboard
		myLogs = new ArrayList<Log>();
		myCars = new ArrayList<Car>();

		// Populates myCars with some cars
		for (int j = 365; j < 496; j += 65) {
			for (int i = 0; i < 4; i++) {
				myCars.add(new Car((int) (Math.random() * 10) * 200, // Starting X
						j, // Starting Y
						1000)); // maxX
			}
		}

		// Adds frog to the game
		myFrog = new Frog(425, // starting X
				560, // starting Y
				0, // starting direction
				50, // min X
				-50, // min Y
				800, // max X
				550); // max Y

		// Populates myLogs with some logs
		for (int j = 235; j > 40; j -= 65) {
			for (int i = 0; i < 5; i++) {
				myLogs.add(new Log((int) (Math.random() * 10) * 200, // Starting X
						j, // Starting Y
						1000)); // maxX
			}
		}
	}

	public void startGame() {
		while (true) {
			// checks to see if the frog has reached the end (able to level up)
			if (levelUp) {
				// Every 5th level, the game adds more logs and cars to increase difficulty
				if (level % 5 == 0) {
					// Clears the logs
					myLogs = new ArrayList<Log>();

					// Repopulates with more logs
					int moreItems = 5 - (level / 5);
					if (moreItems < 1)
						moreItems = 1;

					// populates myLogs with moreItems number of logs for each row in the river
					for (int j = 235; j > 40; j -= 65) {
						for (int i = 0; i < moreItems; i++) {
							myLogs.add(new Log((int) (Math.random() * 50) * 200, // Starting X
									j, // Starting Y
									1000)); // maxX
						}
					}

					// populates myCars with moreItems number of cars for each row in the road
					for (int j = 365; j < 496; j += 65) {
						for (int i = 0; i < moreItems; i++) {
							myCars.add(new Car((int) (Math.random() * 100) * 200, // Starting X
									j, // Starting Y
									1000)); // maxX
						}
					}
				}

				// Every level, increases the speed of the logs and cars
				MovingObstacle.speed /= .6;
				levelUp = false;
			}

			// Frog movements
			while (KL.left) {
				myFrog.turnLeft();
				KL.left = false;
			}
			while (KL.right) {
				myFrog.turnRight();
				KL.right = false;
			}
			while (KL.up) {
				myFrog.turnUp();
				KL.up = false;
			}
			while (KL.down) {
				myFrog.turnDown();
				KL.down = false;
			}

			// Checks to see if cars have driven off the map and if so, resets them
			for (Car c : myCars) {
				if (c.getX() > 850)
					c.setX((int) (c.getX() - 850 - Math.random() * 200));
			}

			// Checks to see if logs have gone off the map and if so, resets them
			for (Log l : myLogs) {
				if (l.getX() > 850)
					l.setX((int) (l.getX() - 850 - Math.random() * 200));
			}

			// Checks to see if the frog has progressed to the next level
			if (myFrog.getY() < 0) {
				txtPanel.levelUp();
				level++;
				levelUp = true;
				myFrog.reset();
			}
			repaint();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Paints the river, grass, and road
		g.setColor(new Color(3, 0, 75));
		g.fillRect(0, 72, 850, 196);
		g.setColor(Color.green);
		g.fillRect(0, 0, 850, 72);
		g.fillRect(0, 267, 850, 65);

		// Draws each car, log, and the frog
		for (int i = 0; i < myCars.size(); i++)
			myCars.get(i).draw(frame, g);
		for (Log l : myLogs)
			l.draw(frame, g);
		myFrog.draw(frame, g);

		// Checks to see if the frog has collided with any car
		for (Car c : myCars) {
			if (myFrog.isColliding(c)) {
				myFrog.drawExplosion(frame, g);// explosion!!!
				txtPanel.frogDie();
				myFrog.reset();// resets game if the frog dies
				return;
			}
		}

		// moves the cars and logs
		for (Log l : myLogs)
			l.move();
		for (Car c : myCars)
			c.move();

		// sees if the frog is in the river
		if (myFrog.isInRiver()) {
			for (Log l : myLogs)// he can't drown if he's on a log
			{
				if (myFrog.isColliding(l))// moves the frog with the log
				{
					myFrog.frogMove(l.getSpeed());
					return;
				}
			}

			// The frog is drowning :(
			myFrog.drawExplosion(frame, g);// explosion!!!
			txtPanel.frogDie();
			myFrog.reset();// resets game if the frog dies
			return;
		}
	}

	public static void pause(long millisecs) {
		try {
			Thread.sleep(millisecs);
		} catch (Exception e) {
			for (long i = 0; i < 999999; i++)
				System.out.println("Nick Rocks!");
		}
	}
}
