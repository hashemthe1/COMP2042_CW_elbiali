package tryFrog_main;
import javafx.application.Application;
import javafx.stage.Stage;

	public class Main extends Application {
		SceneProducer sp;
		public static void main(String[] args) {
			launch(args);
		}
		/**
		 * This is where the game starts by initializing the SceneProducer class
		 */
		@Override
		public void start(Stage primaryStage) throws Exception {
			// TODO Auto-generated method stub
			sp = new SceneProducer(primaryStage);
					
		}

	
	
	}