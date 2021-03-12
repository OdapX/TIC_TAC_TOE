/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application   {
      public static  Stage stage = new Stage();
    @Override
    public void start(Stage arg0) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/Ddd.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TIC_TAC_TOE");
        stage.show();
        
    }

    public static void main(String[] args) {
		 launch(args);

	}
}