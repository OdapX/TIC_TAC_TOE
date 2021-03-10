package tictactoe_Game;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class winning extends Application{

		 @Override
	    public void start(Stage primaryStage) {
	        StackPane root = new StackPane();
	        root.setId("pane");
	        BackgroundImage myBI= new BackgroundImage(new Image("D:\\pic",32,32,false,true),
	                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	                  BackgroundSize.DEFAULT);
	        //then you set to your node
	        root.setBackground(new Background(myBI));
	        Scene scene = new Scene(root, 300, 250);
	        primaryStage.setScene(scene);
	        
	        primaryStage.show();
	    }
	
	public static void main(String[] args) {
	launch(args);
	}
	

}

	

