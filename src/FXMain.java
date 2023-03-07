

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        String path = "C:/Users/shiha/Documents/NetBeansProjects/To-do list assignment/src/list.txt";
        String deletionPath = "C:/Users/shiha/Documents/NetBeansProjects/To-do list assignment/src/delete.txt";
        File file = new File(path);
        File DeleteTaskFile = new File(deletionPath);
        if(!file.exists()){
            try {
            file.createNewFile();
            System.out.println("File has been created!!");
            } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("list.txt already exists!!");
        }
        if(!DeleteTaskFile.exists()){
            try {
                DeleteTaskFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("delete.txt already exists!!");
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setTitle("Todo List");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
