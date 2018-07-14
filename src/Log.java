/*
 * Log is a type of moving obstacle and most of log's implementation is in
 * moving obstacle. See documentation in MovingObstacle.java
 */
class Log extends MovingObstacle {
	public Log(int x1, int y1, int maxX1) {
		// Call's MovingObstacle's constructor with the dimensions of the log (100x50)
		// and the image of the log to be used.
		super(x1, y1, maxX1, 100, 50, "assets/log.png");
	}

}