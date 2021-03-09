package tictactoe_Game;


import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class tictactoe extends Application {
	   private boolean used_O,used_X ; //to prevent playing X or O in a row
	   private int id_box=0,count=0;
	   /* function to create  scene */
	      private Scene create_scene(double height,double width) {
		  Pane root= new Pane();
		  root.setPrefSize(height, width);
		 
		  /*each rectangle must be height/3 and width/3 to fit in the pane*/
		  /*create a 6 box displayed as a grid */
		  for (int j=0;j<3;j++) {
		      for(int i=0;i<3;i++) {
		       Container container = new Container(height/3,width/3,id_box++);  
		        container.setTranslateX(i*width/3);
		        container.setTranslateY(j*width/3);
		        root.getChildren().add(container);
		    }
		 }
		  
      	  return new Scene(root);
		  }
	
	  
	  
	@Override
	public void start(Stage stage0) throws Exception {
		stage0.setScene(create_scene(500,500) );

		stage0.setTitle("TIC_TAC_TOE");
		stage0.show();
	}
	
	//class to generate boxs 
	public class Container extends StackPane{
		private Label label =new Label();
		private Button btnO = new Button("0");
	    private Button btnX = new Button("X");
	    private int id;
	    private boolean used=false ;//to block multiple changements of same box
	    
		public Container(double height, double width,int id_box) {
			id=id_box;
		    Rectangle border = new Rectangle(height,width);
		    border.setStroke(Color.BLACK);
		    border.setFill(Color.TRANSPARENT);
		    setAlignment(Pos.CENTER);
		    /*adding label-text properties ->font size and color */
		    
		    label.setFont(new Font("Arial", 70));
		    label.setTextFill(Color.web("#0076a3"));
		    
		    /* putting the buttons at the buttom of the box*/
		    
		    btnO.setTranslateX(-28);
		    btnO.setTranslateY(70);
		    btnX.setTranslateX(23);
		    btnX.setTranslateY(70);
//		    btnO.setStyle("-fx-background-color: #00ff00");
//		    btnX.setStyle("-fx-background-color: #00ff00");
		    btnO.setMinWidth(50);
		    btnX.setMinWidth(50);
		    /*Event handling of Buttons*/
		    
		    btnO.setOnAction(new EventHandler<ActionEvent>() {

		        @Override
		        public void handle(ActionEvent event) {
		            if(used) return;
		            if(used_O) return;
		            btnO.setStyle("-fx-background-color: #00ff00");
		            Put_O();
		        	used=true;
		        	used_O=true;
		        	used_X=false;
		        	is_full();
		        	count++;
		            
		        }
		    });
		    	
		    
		    
		btnX.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent event) {
	        	if(used) return;
	        	if(used_X) return;
	        	btnX.setStyle("-fx-text-fill: #FFFFFF");
	        	btnX.setStyle("-fx-background-color: #0000FF");
	        	
	        	Put_X();
	            used=true;
	            used_X=true;
	            used_O=false;
	            is_full();
	            count++;
	        }
	    });
	    	 // adding the border to the stackpane aka container
		    getChildren().addAll(border,label,btnO,btnX);
		    
		    
		}
		
		private void Put_X() {
			 label.setText("X"+id);
		    }
		private void Put_O() {
			 label.setText("O"+id);
		    }
		
	}
	public void Win() {
	  
	}
	public void is_full() {
		if(count==8) System.out.print("Full+++");//here display DRAW NO WINNER
	}
	
	public static void main(String[] args) {
		 launch(args);

	}

}
