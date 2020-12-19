package player_act;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import tryFrog_main.World;

import java.util.ArrayList;



/**
 * Abstract class is used to define all objects in the game
 */
public abstract class Actor extends ImageView{

	/**
	 *speed of moving objects
	 */
	protected double speed;
	
	
	protected Act act;
	
	protected String type;
	/**
	 * The functionality of each object
	 */
	
	
	
	/**
	 * Images are used to store the all death animations  and movement animations
	 */
	protected Image image1;
	protected Image image3;
	protected Image image4;
	protected Image image2;

	
	/**
	 * Player related variables
	 */

    protected boolean carDeath,waterDeath;
    public static int points;
    protected double movement;
	protected int imgSize;
	protected boolean sunk=false;
	
	 /**
     * @return the parent node, the root node
     */
    public World getWorld() {
        return (World) getParent();
    }

	
	/**
	 * Move the object number of pixels in both x and y directions
	 * @param dx number of pixels to move in the x direction
	 * @param dy number of pixels to move in the y direction
	 */
    public void move(double dx, double dy) {
        setY(getY() + dy);

        setX(getX() + dx);
    }
    

    
   

    
    /**
     * Method to check intersection between objects
     * @param <A> an empty arraylist
     * @param cls The object to check intersections with
     * @return an array containing all actors that are intersecting
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
 
    
    
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    public String getType() {
 	   return type;
    }

   /**
    * A call to the encapsulated method act
    * @param now game timer
    */
    public void act(long now) {
    	act.act(this,now);
    
    } 
    /**
     * @see World#checknextfree(String)
     * @return the type of actor 

     */
   


}