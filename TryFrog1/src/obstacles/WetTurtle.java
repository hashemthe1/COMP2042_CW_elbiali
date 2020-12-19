package obstacles;


import javafx.scene.image.Image;
import player_act.ActONTurtle;
import player_act.Actor;
import player_act.ActorMovement;
import player_act.DeathAct;
import player_act.StaticMovement;
import player_act.Act;



/**
 * this class is used for wet turtle and it has the turtle functionality 
 */
public class WetTurtle extends Actor{
	
	int dim=100;
	/**
	 * the constructor assigns the images of the turtle and the type that is  used to determine position
	
	 * @param s is the speed of the object
	 */
	public WetTurtle( double s) {
		int ypos=0;
		int temp=0;
		int xpos=0;

		
		act=new ActONTurtle();
		image1 = new Image("file:src/resources/TurtleAnimation1.png", dim, dim, true, true);
		image2 = new Image("file:src/resources/TurtleAnimation2Wet.png", dim, dim, true, true);
		image4 = new Image("file:src/Images/TurtleAnimation4Wet.png", dim, dim, true, true);

		image3 = new Image("file:src/resources/TurtleAnimation3Wet.png", dim, dim, true, true);
		type="Turtle"+String.valueOf(s);
		
		if (s>0) {
			image1 = new Image("file:src/resources/TurtleAnimation1right.png", dim, dim, true, true);
			image3 = new Image("file:src/resources/TurtleAnimation3Wet.png", dim, dim, true, true);
			image2 = new Image("file:src/resources/TurtleAnimation2Wet.png", dim, dim, true, true);

		}
			
		if (temp!=0) {ypos=temp;}
		setY(ypos);
	
		setX(xpos);
		speed = s;
		setImage(image2);
	}
	
	/**
	 * checks if the turtle is sunk or is not 
	 * @return boolean is the turtle is sunk or not
	 */
	public boolean isSunk() {
		return sunk;
	}
	/**
	 * method to get the speed of turtle
	 * @return double which is the speed of the turtle
	 */
	public double getspeed() {
		return speed;
	}
}

