package digits;

import javafx.scene.image.Image;
import player_act.Actor;
import player_act.ActorMovement;
import tryFrog_main.Player;



public class End extends Actor{
	boolean activated = false;
	int dim=70;
	
	
	int xpos[]= {10,120,250,325,430};
	int ypo=91;

	
	static int j=0;
	
	
	//an array that stores all the positions of each hole that should be in
	 
	public End() {  
		
		act=new ActorMovement();
		//end hole
		setX(xpos[j]);
		
		setY(ypo);
		j++;
		
		if(j==5) {j=0;}
		setImage(new Image("file:src/resources/End.png", dim, dim, true, true));
	}
	
	//trigger hole if frog reaches it
	public void setEnd() { 
		setImage(new Image("file:src/resources/FrogEnd.png",dim, dim, true, true));
		
		activated = true;//adding the frog image to see if its triggered 
	}
	
	 
	
	public boolean isactivated() { 
		
//check if hole is activated
		return activated; //return activated if true
	}

	

}
