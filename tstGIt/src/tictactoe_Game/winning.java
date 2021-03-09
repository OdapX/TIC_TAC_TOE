package tictactoe_Game;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class winning extends Application{

	
	@Override
	public void start(Stage stage) throws Exception {
		GridPane grille = new GridPane();
		Scene scene= new Scene(grille,500,500);
		
//********************Event Button Quitter********************************	
		
		stage.setScene(scene);
		stage.setTitle("CONGRATS");
		stage.show();
		
	}
	
	public static void main(String[] args) {
	launch(args);
	}
	

}

	

