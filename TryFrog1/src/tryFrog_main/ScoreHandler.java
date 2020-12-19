package tryFrog_main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * class handles reading  and writing the player score to and from a list
 *
 */
public class ScoreHandler {
	public ArrayList<String> names;
	public ArrayList<Score> scores;
	
	
	int score=0;
	
	Player player;
	
	public File file;
	
	/**
	 * The constructor checks for the text file , and creates one if it doesnt exist, it also calls the readscores function to initialise the scoreboard
	 */
	public ScoreHandler() {
		
		scores = new ArrayList<Score>();
		ArrayList<String> names = new ArrayList<String>();
		
		File file=new File("scoretext.txt");//link the scoreset file
		try {
			if (file.createNewFile()) {
		        System.out.println("File created: " + file.getName());
		      } else {
		    	  
		    	  
		        System.out.println("File already exists.");
		      }
		}
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		readscores();
		
 
		
		
		
	}
	
	/**
	 *Function writes the new data into the file  it works by first the adding of the new score to the scores list. and then writing entities of the list to file 
	 * @param name the name the player wants to be used
	 * @param score the score the player has accumulated
	 * @param level the level the player has been reached
	 * checks for an existing name, and if it exists and is lower than the new score, then it will replace  lower score with the higher score
	 */
	public void writescores(String name,int score,int level) {
		boolean found=false;
		
		for (int x=0;x<scores.size();x++) {	
			if(scores.get(x).Name.equals( name)) {
				if(scores.get(x).Score < score) {
				scores.get(x).Level=level;
				scores.get(x).Score=score;
				
				}
				found=true;
			}
		}
		if (!found) {
			scores.add(new Score(name,score,level));
		}
	    
	    try {
		    FileWriter myWriter = new FileWriter("scoretext.txt");
		    // write in the score text file
			for (int i=0;i<scores.size();i++) {		
				//if their is equal scores
				if (!scores.get(i).Name.equals("")) {
			    myWriter.write(scores.get(i).Name+"\n"+scores.get(i).Score+"\n"+scores.get(i).Level+"\n");
				}
			}
			myWriter.close();
	    }
		catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
	    }
		 
	}
	
	/**
	 * The function is used to read the score fro the text and stores it in the array
	 */
	public void readscores() {
		int secon=1;
		String user="";
		int score=0;
		//inisilize the score to 0
		 try {
		      File myObj = new File("scoretext.txt");
		      
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	  String data = myReader.nextLine();
		    	  if(secon==3) {
		    		  
				      scores.add(new Score(user,score,Integer.valueOf(data)));
				      secon=1;
		    	  }
		    	  else if (secon==1) {
		    		  
		    		  secon=2;
		    		  user=data;
		    	  }
		    	  else if (secon==2) {
		    		  secon=3;
		    		  score=Integer.valueOf(data);
		    	  }
		        
		       
		      }
		      myReader.close();
		    } 
		 catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	/**
	 * public method to get the scores of the game
	 * @return an array containing the all the player scores
	 */
	public ArrayList<Score> getscore() {
		return(scores);
	}
	
	
	public int getPoints() {//sends points to classes that is requested
		return (Player.points);
	}
	/**
	 * Method to return player points
	 * @return player points
	 */
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * A function that gets the hiscore
	 * @return the highest score
	 */
	public int gethighscore() {
		int hs=0;
		for(int i=0;i<scores.size();i++) {
			if (scores.get(i).Score>hs) {
				hs=scores.get(i).Score;
			}
		} 
		return(hs);
	}
	
	

	
	
}
