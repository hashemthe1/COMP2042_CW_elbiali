package digits;



import javafx.scene.image.Image;
import player_act.Actor;
import player_act.ActorMovement;


/*
 * Class from changing the score on the screen*/
public class Digit extends Actor{
	int dim; 
	Image im1;
	
	//add images to the score board 
	public Digit(int n, int dim, int x, int y) {
		
		act=new ActorMovement();
		im1 = new Image("file:src/resources/"+n+".png", dim, dim, true, true);
		setImage(im1);
		
		setX(x);
		setY(y);
	}

	
	
	
	
}