package tictactoe_Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class tictactoe extends Application {
	   private boolean used_O,used_X ; //to prevent playing X or O in a row
	   private int count=0,id=0;
	   public  ArrayList<Container> boxes = new ArrayList<>();
	   private Stage stage0=new Stage();
	   List<Integer> O_box=new ArrayList();
	   List<Integer> X_box=new ArrayList();
	   private boolean draw=true;
	   /* function to create  scene */
	      private Scene create_scene(double height,double width) {
		  Pane root= new Pane();
		  root.setPrefSize(height, width);
		 
		  /*each rectangle must be height/3 and width/3 to fit in the pane*/
		  /*create a 6 box displayed as a grid */
		  for (int j=0;j<3;j++) {
		      for(int i=0;i<3;i++) {
		       Container container = new Container(height/3,width/3,id++);  
		        boxes.add(container);
		       container.setTranslateX(i*width/3);
		        container.setTranslateY(j*width/3);
		        root.getChildren().add(container);
		    }
		 }
		  
      	  return new Scene(root);
		  }
	
	  
	  
	@Override
	public void start(Stage stage0x) throws Exception {
		stage0.setScene(create_scene(500,500) );
		stage0.setTitle("TIC_TAC_TOE");
		stage0.show();
	}
	
	//class to generate boxs 
	public class Container extends StackPane{
		private Label label =new Label();
		private Button btnO = new Button("0");
	    private Button btnX = new Button("X");
	    private Button play =new Button("Play Again");
	    private int id_box;
	    private int title=2; //title = 0 if is a O   and =1 if a X
	    private boolean used=false ;//to block multiple changements of same box
	    
		public Container(double height, double width,int id) {
			id_box=id;
		    Rectangle border = new Rectangle(height,width);
		    border.setStroke(Color.BLACK);
		    border.setFill(Color.PINK);
		    setAlignment(Pos.CENTER);
		    /*adding label-text properties ->font size and color */
		    
		    label.setFont(new Font("Arial", 70));
		    label.setTextFill(Color.web("#0076a3"));
		    
		    /* putting the buttons at the buttom of the box*/
		    btnO.setTranslateX(-28);
		    btnO.setTranslateY(70);
		    btnX.setTranslateX(23);
		    btnX.setTranslateY(70);
//		    btnO.setStyle("-fx-background-color: #000000");
//		    btnX.setStyle("-fx-background-color: #800080");
		    btnO.setMinWidth(50);
		    btnX.setMinWidth(50);
		    /*Event handling of Buttons*/
//		    border.setOnMouseClicked(event->{
//
//			//	@Override
//			//	public void handle(MouseEvent arg0) {
//					if(used) return;
//		            
//		            else if(used_X){
//		            Put_O();	
//		            used=true;
//		        	used_O=true;
//		        	used_X=false;
//		        	fill_boxes();
//		        	count++;
//		        	win_X();
//		        	win_O();
//		        	Draw();
//		            }
//		        	if(used_O) {
//		        		Put_X();
//			            used=true;
//			            used_X=true;
//			            used_O=false;
//			            fill_boxes();
//			            count++;
//			            win_X();
//			        	win_O();
//			            Draw();     	
//			           
//		        		
//		        	}
//					
//				//}
//		    	
//		    });
//		   
//		    
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
		        	fill_boxes();
		        	count++;
		        	win_X();
		        	win_O();
		        	Draw();
		            
		        }
		    });
		    	
		btnX.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent event) {
	        	if(used) return;
	        	if(used_X) return;
	        	btnX.setStyle("-fx-text-fill: #FFFFFF");
	        	btnX.setStyle("-fx-background-color: #ff0000");
	        	
	        	Put_X();
	            used=true;
	            used_X=true;
	            used_O=false;
	            fill_boxes();
	            count++;
	            win_X();
	        	win_O();
	            Draw();     	
	           
	        }
	    });
	    	 // adding the border to the stackpane aka container
		  getChildren().addAll(border,label,btnO,btnX);
		    
		    
		}
		
		private void Put_X() {
			 label.setText("X");
			 label.setTextFill(Color.web("#ff0000", 1));
			 title=1;
			 
		    }
		private void Put_O() {
			 label.setText("O");
			 label.setTextFill(Color.web("green", 1));
              title=0;
		    }
		
	}
	
	
	public void fill_boxes() {
	  for(Container c : boxes) {
		  if(c.title==0) 
			  O_box.add(c.id_box); 
		  else if (c.title==1)
			  X_box.add(c.id_box);
		  
		  
	  }
	}
	
 
	
/********************************PLAY AGAIN*******************************/	
 public void restart() {
	 stage0.close();
	 tictactoe window = new tictactoe();
	 Stage stage = new Stage();
	 try {
		window.start(stage);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 }
    	
	
/********************************WIN**************************************/	
public void win_O() {
    boolean win0=O_box.contains(4) && O_box.contains(0) && O_box.contains(8);
    boolean win1=O_box.contains(4) && O_box.contains(1) && O_box.contains(7);
    boolean win2=O_box.contains(4) && O_box.contains(2) && O_box.contains(6);
    boolean win3=O_box.contains(4) && O_box.contains(3) && O_box.contains(5);    
		
    if(win0 || win1 || win2 || win3) {
    	draw=false;
    	System.out.print("WINNER IS O!");
    // create a alert 
         Alert a = new Alert(AlertType.NONE);  
        a.setAlertType(AlertType.INFORMATION); 
        a.setHeaderText(null);
        a.setGraphic(null);
        a.setContentText("PLAYER_O WINS!!!");
    //show  alert 
         
        Optional<ButtonType> result = a.showAndWait();

        if (result.get() == ButtonType.OK) {
           restart();
        }
        
		
    }
	
     
     win0= O_box.contains(0) && O_box.contains(1) && O_box.contains(2);
	 win1= O_box.contains(0) && O_box.contains(3) && O_box.contains(6);	
	 win2=O_box.contains(2) && O_box.contains(5) && O_box.contains(8);
	 win3=O_box.contains(6) && O_box.contains(7) && O_box.contains(8);
     if( win0 || win1 || win2 || win3) {
    	 draw=false;
     System.out.print("WINNER IS O!");
  // create a alert 
     Alert a = new Alert(AlertType.NONE);  
    a.setAlertType(AlertType.INFORMATION); 
    a.setHeaderText(null);
    a.setGraphic(null);
    a.setContentText("PLAYER_O WINS!!!");
    //show   
    Optional<ButtonType> result = a.showAndWait();

    if (result.get() == ButtonType.OK) {
       restart();
    }
     }
     
 	}


public void win_X() {
    boolean win0=X_box.contains(4) && X_box.contains(0) && X_box.contains(8);
    boolean win1=X_box.contains(4) && X_box.contains(1) && X_box.contains(7);
    boolean win2=X_box.contains(4) && X_box.contains(2) && X_box.contains(6);
    boolean win3=X_box.contains(4) && X_box.contains(3) && X_box.contains(5);    

     if(win0 || win1 || win2 || win3) {
    	 draw=false;
    	 System.out.print("WINNER IS X!");
    	// create a alert 
         Alert a = new Alert(AlertType.NONE);  
        a.setAlertType(AlertType.INFORMATION); 
        a.setHeaderText(null);
        a.setGraphic(null);
        a.setContentText("PLAYER_X WINS!!!");
        //show   
        Optional<ButtonType> result = a.showAndWait();

        if (result.get() == ButtonType.OK) {
           restart();
        }
		
     }
     win0= X_box.contains(0) && X_box.contains(1) && X_box.contains(2);
	 win1= X_box.contains(0) && X_box.contains(3) && X_box.contains(6);	
     win2=X_box.contains(2) && X_box.contains(5) && X_box.contains(8); 
     win3=X_box.contains(6) && X_box.contains(7) && X_box.contains(8); 
     
     if(win0 || win1 || win2 || win3) {
    	 draw=false;
    	 System.out.print("WINNER IS X!");
    	// create a alert 
         Alert a = new Alert(AlertType.NONE);  
        a.setAlertType(AlertType.INFORMATION); 
        a.setHeaderText(null);
        a.setGraphic(null);
        a.setContentText("PLAYER_X WINS!!!");
        //show   
        Optional<ButtonType> result = a.showAndWait();

        if (result.get() == ButtonType.OK) {
           restart();
        }
		
     }
      }		
/******************************DRAW****************************************/	
	public void Draw() {
		if(count==9 && draw) {
			System.out.print("DRAW");//here display DRAW NO WINNER
			Alert a = new Alert(AlertType.NONE);  
	        a.setAlertType(AlertType.INFORMATION); 
	        a.setHeaderText(null);
	        a.setGraphic(null);
	        a.setContentText("DRAW!!!");
	        //show   
	        Optional<ButtonType> result = a.showAndWait();

	        if (result.get() == ButtonType.OK) {
	           restart();
	        }
		}
	}
/***************************************************************************/	
	public static void main(String[] args) {
		 launch(args);

	}

}
