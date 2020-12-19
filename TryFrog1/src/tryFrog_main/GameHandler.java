package tryFrog_main;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

//class for starting and ending game session
public class GameHandler {
	
	public MyStage background;
	Stage pt;
	AnimationTimer timer1;//initializing the variables needed
	PlayerController PC;
	
	public Player player1;
	SceneProducer SP;
	
	ScoreHandler scHa;
	
    obstacleFactory obstacle1;
	


	public GameHandler(SceneProducer SP) {
		this.background=SP.background;
		this.pt=SP.primaryStage;
		obstacle1 = new obstacleFactory();
		this.SP=SP;
		this.scHa=SP.ScH;
		
		start();
		
	}

	
	
	//start music timer
	//create the player obj
	//add initial hiscore and score
	//create player controller
	public void start() {
		obstacle1.addobjects(background);
		player1=new Player();
    	background.addfront(player1);
    	
		PC=new PlayerController(player1);
		
		background.playMusic();
    	createTimer();
    	
    	obstacle1.setNumber(scHa.gethighscore(),true);  
    	obstacle1.setNumber(player1.getPoints(),false);  
        timer1.start();
    }
	
	//starts the game timer
	private void createTimer() {
        timer1 = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	PC.checkcontrol();
            	if (player1.changeScore()) {  //if theres been a change in teh score
            		obstacle1.setNumber(player1.getPoints(),false);  
            		}
            	if (checkends()) { //stops everything and alerts player if all 5 ends are filled
            		StopFunctions();
            	}
            }

			
        };
    }
	
	//check if all the holes has been activated
		private boolean checkends() {
			for(int i=0;i<obstacle1.ends.size();i++) {
			if(!obstacle1.ends.get(i).isactivated()) {
				return(false);
			}
			}
			return(true);
		}
	
	// stops game actions of producing if the game ends
	private void StopFunctions() {
		background.lvl=background.lvl+1;
		background.stopMusic();
		timer1.stop();
		background.stop();
		
	
		
		if (background.lvl<10) {
			
		SP.createnextlvlscrn();
		}
		else {SP.createwin();}
	}
	

	
}