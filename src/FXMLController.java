
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.util.Scanner;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class FXMLController implements Initializable {
    String path = "C:/Users/shiha/Documents/NetBeansProjects/To-do list assignment/src/list.txt";
    String deletionPath = "C:/Users/shiha/Documents/NetBeansProjects/To-do list assignment/src/delete.txt";
    @FXML
    private ListView<String> lstView;
    private Parent root;
    private Scene scene;
    private Stage stage;
    private String task;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lstView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                task = lstView.getSelectionModel().getSelectedItem();
                System.out.println("Selected Task: "+task);
                try {
                    FileWriter writer = new FileWriter(deletionPath);
                    writer.write(task);
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    @FXML
    public void Exit(ActionEvent event){
        System.exit(0);
    }
    @FXML
    public void ShowTask(ActionEvent event){
        File file = new File(path);
        try {
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                String task = input.nextLine();
                input.nextLine();
                input.nextLine();
                lstView.getItems().add(task);
            }
            input.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void SceneChange(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Add.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void TaskDetails(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Details.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
