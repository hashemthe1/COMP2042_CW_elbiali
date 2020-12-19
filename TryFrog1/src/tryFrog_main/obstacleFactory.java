package tryFrog_main;


import player_act.Actor;
import digits.Digit;
import digits.End;

import java.util.ArrayList;
import java.util.Collections;

import obstacles.Log;
import obstacles.Turtle;
import obstacles.WetTurtle;
import obstacles.vehicles;



// This class is responsible for inisilizing all game obstacels
public class obstacleFactory{

	/**
	 * This is the root node
	 */
	MyStage background;
	
	/**
	 * The array to keep track of all the digits on top of the screen
	 */
	public ArrayList<Actor> digits;
	
	/**
	 * Array to keep track of all the moving objects
	 */
	
	
	ArrayList<End> ends=new ArrayList<End>();
	ArrayList<Actor> funct=new ArrayList<Actor>();
	double add=0;
	
	
	/**
	 * T instatiate the list that keeps track of the digits on stage
	 */
	public obstacleFactory() {
		
		digits=new ArrayList<Actor>();

		
		}

	/**
	 * This method returns the bonus speed each obstacle should get according to the level reached
	 * Every level the speed increases by 0.05
	 */
	private void getbonus( ) {
		for(int i=0;i<background.lvl;i++) {
			add=add+0.0625;
			
		}
	}
	
	
	
	/**
	 *  instantiates the wet turtles and  turtles and adds them to the function Array which stores the game objects.
	 */
	private void addturtles( ) {


		    funct.add(new Turtle(Double.sum(add, 0.35)));
			funct.add(new Turtle(Double.sum(add, 0.35)));
			funct.add(new WetTurtle(Double.sum(add, 0.35)));
			funct.add(new WetTurtle(Double.sum(-add, -0.35)));
			funct.add(new WetTurtle(Double.sum(-add, -0.35)));
			funct.add(new WetTurtle(Double.sum(-add, -0.35)));
			

		
	}
	
	
	
	/**
	 * Instantiates the logs and adds them to the function array which contains the objects
	 */
	private void addlogs( ) {
		
		
		funct.add(new Log("file:src/resources/log3.png",  Double.sum(add, 0.25)));
		funct.add(new Log("file:src/resources/log3.png",   Double.sum(add, 0.25)));
		funct.add(new Log("file:src/resources/log3.png",   Double.sum(add, 0.25)));
		funct.add(new Log("file:src/resources/logs.png",   Double.sum(-add, -0.45)));
		funct.add(new Log("file:src/resources/logs.png",   Double.sum(-add, -0.45)));
		funct.add(new Log("file:src/resources/log3.png",   Double.sum(add, 0.25)));
		funct.add(new Log("file:src/resources/log3.png",  Double.sum(add, 0.25)));
		funct.add(new Log("file:src/resources/log3.png",  Double.sum(add, 0.25)));
		
	}
	
	
	
	
	/**
	 *  instantiates trucks and cars and adds them to to the function Array that stores the game objects
	 */
	private void addobstacles() {
		funct.add(new vehicles("file:src/resources/truck1"+"Right.png",   Double.sum(0.35,add), 120, 120));
		funct.add(new vehicles("file:src/resources/truck1"+"Right.png",  Double.sum(0.35,add), 120, 120));
		funct.add(new vehicles("file:src/resources/truck1"+"Right.png",  Double.sum(0.35,add), 120, 120));
		funct.add(new vehicles("file:src/resources/car1Left.png",  Double.sum(-0.35,-add), 50, 50));
		funct.add(new vehicles("file:src/resources/car1Left.png",  Double.sum(-0.35,-add), 50, 50));
		funct.add(new vehicles("file:src/resources/car1Left.png",  Double.sum(-0.35,-add), 50, 50));
		funct.add(new vehicles("file:src/resources/car1right.png",  Double.sum(0.55,add), 50, 50));
		funct.add(new vehicles("file:src/resources/truck2Right.png",  Double.sum(0.35,add), 200, 200));
		funct.add(new vehicles("file:src/resources/truck2Right.png",   Double.sum(0.35,add), 200, 200));
		funct.add(new vehicles("file:src/resources/car1Left.png",  Double.sum(-0.35,-add), 50, 50));
		
	
		
		
	}
	
	/**
	 *Instantiates the five end holes in the game and inserts them to the game background
	 */
	private void addends( ) {
		ends.add(new End());
		ends.add(new End());
		ends.add(new End());
	}
	

	

	
	/**
	 
	 * @param background this is the root node of the scene all the  objects need to be attached to it as the child
	 * shuffles the objects in the array and adds them to the game
	 *
	 */
	public void addobjects(MyStage background) {
		this.background=background;
		//set the  background image |
	  		funct.clear();
	  	    
	  		getbonus();
	  		
	  		
	  		
	  		//adding objects to background makes them children nodes
	  		
	  		
	  		addlogs();
	  		addlogs();
	  		addturtles();
	  		addturtles();
	  		addturtles();

	  		addlogs();

	  		addobstacles();
	  		addends();
	  		addlayout();
	  		addlogs();

	  		

	  		for(int i=0;i<ends.size();i++) {
	  			background.add(ends.get(i));
	  		}
	  		Collections.shuffle(funct);
	  		
	  		for(int i=0;i<funct.size();i++) {
				background.add(funct.get(i));
			}
	  		
	  		background.add(new Digit(0, 30, 400, 40));
	  		
	  		BackgroundImage froggerback = new BackgroundImage("file:src/resources/ikogsKW.png");
	  		background.add(froggerback);
	}
	

	/**
	 *instatiates the hiscore and the score labels on the screen
	 */
	private void addlayout( ) {
		background.add(new layout("file:src/resources/HighScoreimage.png",140, 180, 10));
		background.add(new layout("file:src/resources/Scoreimage.png",100, 360, 10));
	}
	
	/**
	 *  method manages  digits used for the hiscore and score on top of the screen
	 * @param n is the number to be displayed as digits
	 * @param ishigh This boolean tells the method if it should place  digits under the hiscore'if true then under hiscore" or under score
	 *  deletes all the current score digits from the screen before it is updated
	 */
	public void setNumber(int n,boolean ishigh ) {
		// set digits on screen
		
		for(int i=0;i<digits.size();i++) {
			
			background.remove(digits.get(i));
		
		}
		Actor temp;
		int g=400;
    	int shifft = 0;
    
    	if(ishigh) {g=270;}
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  //check number digit by digit
    		  n = d;
    		  temp=new Digit(k, 30, g - shifft, 40);
    		  if(!ishigh) {digits.add(temp);}
    		  background.addfront(temp);//360 is end of number, works backwards
    		  shifft+=30;//move back 30 more pixels
    		}
    }
	
	
}