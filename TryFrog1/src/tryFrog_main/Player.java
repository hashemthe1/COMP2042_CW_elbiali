package tryFrog_main;



import digits.End;


import javafx.scene.image.Image;

import obstacles.Log;
import obstacles.Turtle;
import obstacles.WetTurtle;
import obstacles.vehicles;
import player_act.Actor;
import player_act.Act;
import player_act.ActorMovement;
import player_act.DeathAct;
public class Player extends Actor {


	
	/**
	 * Trigger that alrts for a need to update the score
	 */
	public boolean changeScore = false;  
	
	
	/**
	 * Trigger that locks player movement
	 */
	public boolean noMove = false;  //locks player movement

	
	
	/**
	 * This is the spawn coordinates for the player
	 */
	int spawnposy=710; //spawn position
	
	
	/**
	 * used to check highest score the player reached
	 */
	double highestscore = 1000;//stores highest point player reached
	
	
	/**
	 * Animation timer
	 */
	int carD = 0;  //animation counter
	
	
	
	/**
	 * This is the constructor of the Player class
	 * it sets the player sprite and the spawn position
	 */
	public Player() { //initlize the player
		act=new ActorMovement(); // this is used for the getting ActorMovement
		act = new DeathAct(); // this is used for getting Death act
		imgSize = 50;
		setImage(new Image("file:src/resources/froggerUp.png", imgSize, imgSize, true, true));
		resetPlayerPos();
		movement = 25;
	}
	

	/**
	 * This method is called to by the PlayerController script constantly to check for any intersections between the objects and the player
	 * @see PlayerController
	 */
protected void checkIntersections() {
		
		if (getIntersectingObjects(vehicles.class).size() >= 1) {  //if player hits car
			carDeath = true;
		}
		
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) { //move player with log
				move(getIntersectingObjects(Log.class).get(0).getspeed(),0);

		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) { //move player with turtle
			move(getIntersectingObjects(Turtle.class).get(0).getspeed(),0);
		}
		
		
		//if player on turtle and the tutle is sunk the player is dead
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(getIntersectingObjects(WetTurtle.class).get(0).getspeed(),0);
			}
		}
		
		//if intersecting with the end hole
		else if (getIntersectingObjects(End.class).size() >= 1) {
			
			//if end hole is already activated, undo score additoin || can be more effecient
			if (!getIntersectingObjects(End.class).get(0).isactivated()) {
			
			setHoleActive();
			 highestscore = 800;    //resets highest score to minimum
			resetPlayerPos();
		
			}
		}
		
		else if (getY()<410){   //if you are not on any object after this point u dead :)
			waterDeath = true;
		}
	}

	
	/**
	 * This method handles the event where the player reaches an end point, it will add points and set the appropriate end hole to active
	 */
	private void setHoleActive() {
		//add score
		points+=50;
		changeScore = true;
		getIntersectingObjects(End.class).get(0).setEnd();    //sets hole to activated
		
	}

	
	/**
	 * The death handler method, it plays the animation according to the type of death which is checked in the ActPlayer class
	 * it uses the game timer to go through death sprites
	 * @param  this is the game timer
	 * it also handles anything required for player death, such as position reset and  point deduction
	 */
	public void handledeath(long now) {
		noMove = true;//lock the movement
		
		//play the death animation
		if ((now)% 11 ==0) {
			carD++;
		}
		if (carD==1) {
			setImage(image1);
		}
		if (carD==2) {
			setImage(image2);
		}
		if (carD==3) {
			setImage(image3);
		}
		if (carD == 4) {
			if (image4!=null) {setImage(image4);}
		}
		if (carD == 5) {
			//reset the position player
			resetPlayerPos();
			
			//reset the  death triggers
			waterDeath = false;   
			carDeath=false;
					
			//reset the animation
			carD = 0;   
			setImage(new Image("file:src/Images/froggerUp.png", imgSize, imgSize, true, true)); 
			//reset the player sprite
			noMove = false;  
			//unlock movement
			if (points>50) { 
				//deduct the points if possible
				points-=50;
				changeScore = true;
			}  
		}
	}

	/**
	 * Rest the frog postion
	 */
	private void resetPlayerPos() {
		setX(299);
		setY(spawnposy);
	}
	
	/**
	 * Returns the number of the total points the player have gathered
	 * @return points, an integer representing the player's points
	 */
	public int getPoints() {//sends points to calses that has been requested
		return (points);
	}
	
	
	/**
	 * This is a public method that can be called to check wheather there has been a change in the score
	 * @return a boolean that showes if the score has changed
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	

}