package tryFrog_main;



import javafx.scene.image.Image;
import player_act.Actor;

public  class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}
	
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}


}