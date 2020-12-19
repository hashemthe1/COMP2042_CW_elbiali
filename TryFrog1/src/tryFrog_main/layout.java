package tryFrog_main;

import javafx.scene.image.Image;
import player_act.Actor;
import player_act.ActorMovement;

//class used for highscore and score at the top of the screen
public class layout extends Actor{

	int dim=100; 
	Image im1;
	
	public layout(String imageLink,int dim, int xpos,int ypos) {
		
		act=new ActorMovement();
		
		setImage(new Image(imageLink, dim,dim, true, true));
		setY(ypos);
		setX(xpos);

	}

}
