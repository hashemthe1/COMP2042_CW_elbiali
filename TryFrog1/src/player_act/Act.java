package player_act;

public interface Act {
	public void act(Actor actor,long now);
	public void restrictmovement(Actor actor);
	
}
