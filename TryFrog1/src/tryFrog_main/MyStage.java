package tryFrog_main;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MyStage extends World{
	MediaPlayer mediaPlayer;
	public int lvl = 0;
	
	public void act(long now) {
		
	}
	
	public MyStage() {
		

	}
	//playes the game music
	public void playMusic() {
		String musicFile = "src/resources/frogger.mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	// mute the sound
	public void mute(boolean value) {
		if(value) {
			mediaPlayer.stop();
		}else {
			this.playMusic();
		}
	}
	
	//stops music
	public void stopMusic() {
		mediaPlayer.stop();
	}

}



