package application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class controller implements EventHandler {

	@Override
	//Starting the game
	public void handle(Event arg0) {
		Main.stage.close();
		tictactoe window = new tictactoe();
		 Stage stage = new Stage();
		 try {
			window.start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 }
		
	}


