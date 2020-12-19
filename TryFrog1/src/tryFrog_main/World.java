package tryFrog_main;
//commented
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

import player_act.Actor;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


/**
* A class for the game scene, it handles object interactions with the world
*
*/
public abstract class World extends Pane {
    private AnimationTimer timer;
    
    static int[] positionxaxis=new int[] {0,0,0,0,0,0,0,0,0,0,0};
	static int[] positionfull=new int[] {3,3,3,3,3,3,3,3,3,3,3};
    static String[] positionslots=new String[] {"","","","","","","","","","",""};

	
    
    
    /**
     * This constructor is set to define key input/output functions whenever a scene change has been detected
     */
    public World() {

    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					
					/**
					 * This function handles input/output and is overridden in PlayerController
					 */
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						
						@Override
						public void handle(KeyEvent event) {  
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					
					/**
					 * Another function to handle key input/output thats overridden in playercontroller function
					 */
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }


    
    /**
     * stop game timer ending the game
     */
    public void stop() {
        timer.stop();
    }
    
    
    
    /**
     * This function starts a game timer and calls the act functionality of each actor
     */
    public void createTimer() {
        timer = new AnimationTimer() {
        	
            @Override
            public void handle(long now) {
                List<Actor> actors = getObjects(Actor.class);
                
               
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
                
      
            }
        };
    }
    
    
    
    

    /**
     * script starts and it calls to start the game timer
     */
    public void start() {
    	createTimer();
        timer.start();
    }

   
    
   
    public void addfront(Actor actor) {
    	
    	getChildren().add(getChildren().size(),actor);
    }
    
    /**
     * function is used to add all the objects to the stage at the lowest layer after adding the object it then calls the checknextfree to see 
     * where the object should be placed.
     *  if its of the type that requires it
     * @param actor the object to be added, as a child node
     */
    public void add(Actor actor) {
        getChildren().add(0,actor);
        if (actor.getType()!=null) {
        	position temp=checknextfree(actor.getType());
        	if(temp!=null) {
            	actor.setX(temp.x);

        	actor.setY(temp.y);
        	}
        	else {
        		remove(actor);
        	}
        }
        
    }
    
    
    
    /**
     * function that resets all the stage data to start a new game scene
     *  removes all the children and resets slot system.
     */
    public void removeall() {
        getChildren().removeAll();
    	positionfull=new int[] {3,3,3,3,3,3,3,3,3,3,3};
        positionslots=new String[] {"","","","","","","","","","",""};

    	positionxaxis=new int[] {0,0,0,0,0,0,0,0,0,0,0};
    
    }
    
    
    
    
    /**
     * Function to remove actor from the root node
     * @param actor the actor to be deleted from the stage
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

  
    
    /**
     * Searches through the root children for a specified node
     *  * @param cls the node to be searched for
     * @param <A> an empty array
     * @return a list of all the objects of that node
     */

    
  /**
   * method implements a slot system that checks  next slot on the Y axis that the obstacle can be added to
   * @param type the type of object to be aded
   */
public position checknextfree(String type) {
	Random rand = new Random(); 
	position pos=new position(0,710);
	int j=0;
	if (type.contains("Turtle") || type.contains("Log")) {
		j=6;
	}
	else {j=0;}
	for ( int i=j; i < positionfull.length; i++) {
		if(i==5) {
			return null;
		}
		
		pos.y=710-50*(i+1);
		
		
		if (positionslots[i]=="") {
			positionslots[i]=type;
			//the x coord for the first item in a slot is random
			pos.x=rand.nextInt(140)+10;
			
			positionxaxis[i]=pos.x;
			if(type.contains("truck")) {
				positionfull[i]=positionfull[i]-2;
			}
			else {
			positionfull[i]--;
			}
			return(pos);
		}
		else {
			if (positionfull[i]>0) {
				if (positionslots[i].contentEquals(type)) {
					pos.x=positionxaxis[i]+(rand.nextInt(70)+150);
					positionxaxis[i]=pos.x;
					if(type.contains("truckbig")) {
						positionfull[i]=positionfull[i]-2;
						pos.x=pos.x+80;
					}
					else {
					positionfull[i]--;
					}
					return(pos);
				}
				else {
				}
		}
		}
		
	}
	return(null);
}


public <A extends Actor> List<A> getObjects(Class<A> cls) {
    ArrayList<A> someArray = new ArrayList<A>();
    for (Node n: getChildren()) {
        if (cls.isInstance(n)) {
            someArray.add((A)n);
        }
    }
    return someArray;
}

}