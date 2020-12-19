package obstacles;


import javafx.scene.image.Image;
import player_act.ActONTurtle;
import player_act.Actor;
import player_act.ActorMovement;
import player_act.DeathAct;
import player_act.StaticMovement;
import player_act.Act;

/**
 * this class is used for turtle and it has the turtle functionality 
 * @author khaled
 *
 */
public class Turtle extends Actor{
	
	int dim=100;
	
	/**
	 * the constructor assigns images of the turtle and a type to be used to determine position
	 * @param xpos position of object on the x axis
	 * @param s the speed of the object
	 */
	public Turtle(double s) {
		int temp=0;
		int ypos=0;
		int xpos=0;
		act=new ActONTurtle();
		
		//import turtle 
		
		image1 = new Image("file:src/resources/TurtleAnimation1.png", dim, dim, true, true);
		image2 = new Image("file:src/resources/TurtleAnimation2.png", dim, dim, true, true);
		image3 = new Image("file:src/resources/TurtleAnimation3.png", dim, dim, true, true);
		image4 = null;
		//setting the images of the turtle
		
		type="Turtle"+String.valueOf(s);
		
		if (s>0) {
			
	
			image1 = new Image("file:src/resources/TurtleAnimation1mirror.png", dim, dim, true, true);
			image2 = new Image("file:src/resources/TurtleAnimation2mirror.png", dim, dim, true, true);
			image3 = new Image("file:src/resources/TurtleAnimation3mirror.png", dim, dim, true, true);
			
			
		}
		
		
	
		if (temp!=0) {ypos=temp;}
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(image2);
	}
	
	/**
	 * Player to move alongside the turtle
	 * @return  speed of the turtle
	 */
	public double getspeed() {
		return speed;
	}

}