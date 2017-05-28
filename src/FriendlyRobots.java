import java.awt.Color;
import java.util.Random;
 
import org.jointheleague.graphical.robot.Robot;
 
/**
 * FriendlyRobots: This recipe creates 2 robots in opposite corners of the canvas, and moves them a random distance
 * towards each other until they overlap.
 * 
 *
 */
public class FriendlyRobots {
	// Starting positions
	int xPosLeft = 30;
	int yPosTop = 30;
	int xPosRight = 1200;
	int yPosBottom = 700;
 
	int maxNumGames = 30;
	int maxMoves = 200;
 
	public FriendlyRobots() {
 
		// 1. Create and initialize 2 robots.
 Robot robot1=new Robot();
 Robot robot2=new Robot();
 
		// 2. fill in the steps(a,b, and c) in the setupRobot method.
 
		// 3. call the setupRobot method using your two robots.
 setupRobot(robot1, Color.LIGHT_GRAY);
 setupRobot(robot2,Color.ORANGE);
		// 4. Move robots back to the top-right and bottom-left corners
 int halfx=800;
 int halfy=400;
 robot1.move(450);
 robot2.move(-halfy);
 robot1.turn(90);
 robot2.turn(90);
 robot1.move(halfx);
 robot2.move(-halfx);
 
		// 5. do steps 5-6 repeatedly.
 for (int i =0 ; i < 20; i++) {
	 seekX(robot1,robot2);
	 seekX(robot2, robot1);
	 seekY(robot1,robot2);
	 seekY(robot2,robot1);
}
		// 6. use the seek methods below to have the robots find eachother.
 

 
		// 7.Use the method below to check if robot friends have found each other
 
		// 8. if the robots have found eachother make them sparkle , and dance.
 
		// 9. print out the number of times the robots had to move before the found eachother.
 
		// 10. use a confirmDialog to ask the user if they want to play again.
		// repeat the game until the user says no.
 
	}
 
	private void setupRobot(Robot robot, Color robotColor) {
		// a. set the speed of the robot
		robot.setSpeed(7);
		// b. set the pen color
		robot.setPenColor(robotColor);
		// c. put the pen down.
		robot.penDown();
	}
 
	private void seekX(Robot robot, Robot otherRobot) {
		// Move robot a random X distance towards otherRobot
		if (robot.getX() < otherRobot.getX()) {
			robot.setAngle(90);
			robot.move(new Random().nextInt(100));
		} else if (robot.getX() > otherRobot.getX()) {
			robot.setAngle(-90);
			robot.move(new Random().nextInt(100));
		}
		// Keep robot inside canvas
		if (robot.getX() > xPosRight)
			robot.setX(xPosRight);
		else if (robot.getX() < xPosLeft)
			robot.setX(xPosLeft);
	}
 
	private void seekY(Robot robot, Robot otherRobot) {
		// Move robot a random Y distance towards otherRobot
		if (robot.getY() < otherRobot.getY()) {
			robot.setAngle(180);
			robot.move(new Random().nextInt(100));
		} else if (robot.getY() > otherRobot.getY()) {
			robot.setAngle(0);
			robot.move(new Random().nextInt(100));
		}
		// Keep robot inside canvas
		if (robot.getY() > yPosBottom)
			robot.setY(yPosBottom);
		else if (robot.getY() < yPosTop)
			robot.setY(yPosTop);
	}
 
	private Boolean foundFriend(Robot robot1, Robot robot2) {
		// Check whether robots are within 10 pixels of each other
		if (Math.abs(robot1.getX() - robot2.getX()) < 10 && Math.abs(robot1.getY() - robot2.getY()) < 10)
			return true;
		else
			return false;
	}
 
	public static void main(String[] args) {
		new FriendlyRobots();
	}
}
