package tryFrog_main;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage; 


public class GameProducer {
	public 
	
	Stage PS;
	SceneProducer sp2;
	MyStage background;
	ScoreHandler ScH;
	public 
	Player player;
	
	
	PlayerController pc1;
	obstacleFactory obstacle;
	AnimationTimer timer2;
	
	
	
	
	public GameProducer(SceneProducer sp) {
		this.background=sp.background;
		this.PS=sp.primaryStage;
	
		this.sp2=sp;
		obstacle = new obstacleFactory();
		this.ScH=sp.ScH;
		// start function
		start();
		
	}

	// sets up the game scene
	//plays the music added
	//adds the inital hiscore and score
	//creates the player objects
	public void start() {
		obstacle.addobjects(background);
		player=new Player();
    	background.addfront(player);
		pc1=new PlayerController(player);
		background.playMusic();
    	createTimer();
    	obstacle.setNumber(ScH.gethighscore(),true); 
    	
    	obstacle.setNumber(player.getPoints(),false);  
        timer2.start();
    }
	
	// Starts the game timer
	private void createTimer() {
		
        timer2 = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	pc1.checkcontrol();
            	
            	if (player.changeScore()) {  //if theres been a change in teh score
            		obstacle.setNumber(player.getPoints(),false);  
            		}
            	if (checkends()) { // check if all 5 are filled
            		StopFunctions();
            	}
            }

			
        };
    }
	
	// when the game ends it eathier calles the next level or the winning screen
	private void StopFunctions() {
		background.lvl=background.lvl+1;
		background.stopMusic();
		background.stop();
		
		
		if (background.lvl<10) {
			sp2.createnextlvlscrn();
			}
			else {sp2.createwin();}
	}
	
	/**
	 * This function runs to check that all end holes have been activated
	 * @return true of all holes have been activated, false otherwise
	 */
	private boolean checkends() {
		for(int i=0;i<obstacle.ends.size();i++) {
		if(!obstacle.ends.get(i).isactivated()) {
			return(false);
		}
		}
		return(true);
	}
	
}


