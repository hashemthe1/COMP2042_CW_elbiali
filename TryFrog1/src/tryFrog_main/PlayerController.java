package tryFrog_main;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 * This class is responsible for handling input output of the player
 *
 */
public class PlayerController{
	
	//Animation images
		Image imgW2;
		Image imgA2;
		Image imgS2;
		Image imgD2;
		Image imgD1;

		Image imgW1;
		Image imgA1;
		Image imgS1;
		
		Image imgw;
		Image imga;
		Image imgs;
		Image imgd;
		
		int imSize = 40;
		
		private boolean second = false;   
		double move = 25;
		double movementX = 22;
		
		Player player;
		
		/**
		 * Method sets up the player model by defining all the sprites required for movement
		 * @param animal This is a passed reference of the player object
		 */
public PlayerController(Player player) {
	
	this.player=player;
	
	imgW1 = new Image("file:src/resources/froggerUp.png", imSize, imSize, true, true);
	
	imgA2 = new Image("file:src/resources/froggerLeftJump.png", imSize, imSize, true, true);
	imgS2 = new Image("file:src/resources/froggerDownJump.png", imSize, imSize, true, true);
	imgA1 = new Image("file:src/resources/froggerLeft.png", imSize, imSize, true, true);
	imgS1 = new Image("file:src/resources/froggerDown.png", imSize, imSize, true, true);
	imgW2 = new Image("file:src/resources/froggerUpJump.png", imSize, imSize, true, true);
	imgD2 = new Image("file:src/resources/froggerRightJump.png", imSize, imSize, true, true);
	imgD1 = new Image("file:src/resources/froggerRight.png", imSize, imSize, true, true);
	
	
	

	
}

/**
 *  method is in charge for checking keyboard input and the  arranging appropriate actions once input is detected
 * and it changes animal sprites accordingly
 * since it is a  running function and is caleed checkintersections function
 * @see Player#checkIntersections()
 */
public void checkcontrol() {
	player.checkIntersections();

	//System.out.println(points);
	//when key is first pressed
	player.setOnKeyPressed(new EventHandler<KeyEvent>() {  
		public void handle(KeyEvent event){
			if (player.noMove) {
				//do nothing
			}
			else {
			    if (second) {
			    	
			    	imgs=imgS1;
			    	imgw=imgW1;
			    	imga=imgA1;
			    	imgd=imgD1;
			    	 
			    }
			    else {
			    	imgw=imgW2;
			    	imga=imgA2;
			    	imgs=imgS2;
			    	imgd=imgD2;
			    }
			    
				if (event.getCode() == KeyCode.W) {	  
					player.move(0, -move*2);
					player.setImage(imgw);
	                second = !second;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	player.move(-movementX*2, 0);
	            	player.setImage(imga);
	            	 second = !second;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	player.move(0, move*2);
	            	player.setImage(imgs);
	            	 second = !second;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	player.move(movementX*2, 0);
	            	player.setImage(imgd);
	            	 second = !second;
	            }
			}	
		}
		});	
	player.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (player.noMove) {}
				else {//changes score when move up a row
				if (event.getCode() == KeyCode.W) {	  
					if (player.getY() < player.highestscore) {
						player.changeScore = true;
						
						player.highestscore = player.getY();
						player.points+=10;
					}
					player.setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	player.setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	player.setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	player.setImage(imgD1);
	            	 second = false;
	            }
	        }
			}

		
	});
}

	

}
