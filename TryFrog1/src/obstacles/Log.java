package obstacles;

import javafx.scene.image.Image;
import player_act.Actor;
import player_act.ActorMovement;

public class Log extends Actor {

	int dim=100;
	
	/**
	 * instatiates the log and sends it to world to check a free strip
	 * and places it on in the game using the checknextfree 
	 * @param imageLink the location of the log image
	 * @param s the speed the log moves in
	 * @see World#checknextfree
	 * @param xpos the starting x coordinate
	 */
	public Log(String imageLink, double s) {
		act=new ActorMovement();
		
		
		int xpos=0;
		int ypos=0;
		int temp=0;
		
		setImage(new Image(imageLink, dim,dim, true, true));
		type="Log"+String.valueOf(s);
	
		if (temp!=0) {ypos=temp;}
			
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	
	/**
	 *method to move alongside the log
	 * @return the speed of the log
	 */
	public double getspeed() {
		return speed;
	}
}