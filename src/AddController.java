

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddController implements Initializable {
    @FXML
    private DatePicker date;
    @FXML
    private TextField txtField;
    @FXML
    private TextArea txtArea;
    private Parent root;
    private Scene scene;
    private Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    public void Saved(ActionEvent event){
        String task = txtField.getText();
        String details = txtArea.getText();
        String datetxt = date.getValue().toString();
        String path = "C:/Users/shiha/Documents/NetBeansProjects/To-do list assignment/src/list.txt";
        try {
            FileWriter writer = new FileWriter(path,true);
            BufferedWriter bWriter = new BufferedWriter(writer);
            PrintWriter pWriter = new PrintWriter(bWriter);
            pWriter.write(task);
            pWriter.write("\n");
            pWriter.write(details);
            pWriter.write("\n");
            pWriter.write(datetxt);
            pWriter.write("\n");
            pWriter.close();
            bWriter.close();
            writer.close();
            System.out.println("Saved");
        } catch (IOException ex) {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void ToMain(ActionEvent event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void Exit(ActionEvent event){
        System.exit(0);
    }
    @FXML
    public void BackToMain(ActionEvent event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
