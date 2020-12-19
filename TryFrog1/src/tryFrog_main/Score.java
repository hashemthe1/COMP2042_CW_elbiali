package tryFrog_main;

public class Score{


    public String Name;
    public int Score;
    public int Level;
  
 
    /**
     * The constructor
     * @param name the Name the player wants to use
     * @param score the score the player has accumulated
     * @param Level the level the player has reached
     */
    public Score(String name, int score,int level) {
    	
        
      
        this.Level=level;
        this.Name = name;
        this.Score = score;
    }
    public String getName() {// get the name
    	return(Name);
    }
    
    public int getScore() {//get the score
    	return(Score);
    }
    
    public int getLevel() {//get the level
    	return(Level);
    }
    
    public void setName(String Name) {
    	this.Name=Name;
    }
	    
	    public void setScore(int Score) {
    	this.Score=Score;
    }
    
    public void setLevel(int Level) {
    	this.Level=Level;
    }
    
   
    
}
