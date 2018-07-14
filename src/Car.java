/*
 * Car is a type of moving obstacle and most of car's implementation is in
 * moving obstacle. See documentation in MovingObstacle.java
 */
class Car extends MovingObstacle {
	public Car(int x1, int y1, int maxX1) {
		// Call's MovingObstacle's constructor with the dimensions of the car (100x50)
		// and the image of the car to be used.
		super(x1, y1, maxX1, 100, 50, "assets/car.png");
	}
}