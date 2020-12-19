package player_act;



/**
 * This functionality is used for wet turtles and turtles
 *
 */
public class ActONTurtle implements Act {

	
	/**
	 * Ensures turtle wont go off the screen
	 */
	@Override
	public void restrictmovement(Actor actor) {//if sprite goes out of frame, put it back at beginning

		if (actor.getX() > 600 && actor.speed>0)
			actor.setX(-200);
		if (actor.getX() < -100 && actor.speed<0)
			actor.setX(600);
		
	}
	
	
	
	/**
	 * method is in charge of movement animations
	 */
	public void act(Actor actor, long now) {
		
	
		restrictmovement(actor);
		
		if (now/900000000  % 4 ==0) {
			actor.setImage(actor.image2);
			actor.sunk = false;
			
		}
		else if (now/900000000 % 4 == 1) {
			actor.setImage(actor.image1);
			actor.sunk = false;
		}
		else if (now/900000000 %4 == 2) {
			actor.setImage(actor.image3);
			actor.sunk = false;
		} else if (now/900000000 %4 == 3) {
			if (actor.image4!=null) {
			actor.setImage(actor.image4);
			actor.sunk = true;
			}
		}
	
		actor.move(actor.speed , 0);



	}

	

}
