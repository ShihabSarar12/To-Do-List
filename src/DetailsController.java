
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DetailsController implements Initializable {
    String path = "C:/Users/shiha/Documents/NetBeansProjects/To-do list assignment/src/list.txt";
    String deletionPath = "C:/Users/shiha/Documents/NetBeansProjects/To-do list assignment/src/delete.txt";
    String newFilePath = "C:/Users/shiha/Documents/NetBeansProjects/To-do list assignment/src/Temp.txt";
    @FXML
    private TextField date;
    @FXML
    private TextArea txtArea;
    @FXML
    private TextField txtField;
    private String details; 
    private String detailsTxt;
    private String dateTxt;
    private Parent root;
    private Scene scene;
    private Stage stage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file = new File(path);
        File DeleteTaskFile = new File(deletionPath);
        try {
            Scanner input = new Scanner(DeleteTaskFile);
            details = input.nextLine();
            input = new Scanner(file);
            while(input.hasNext()){
                String task = input.nextLine();         
                if(task.equals(details)){
                    txtField.setText(task);
                    detailsTxt = input.nextLine();
                    txtArea.setText(detailsTxt);
                    dateTxt = input.nextLine();
                    date.setText(dateTxt);
                }
                else{
                    input.nextLine();
                    input.nextLine();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void Exit(ActionEvent event){
        System.exit(0);
    }
    /*
    @FXML
    public void DeleteTask(ActionEvent event){
        String line = null;
        File file = new File(path);
        File temp = new File(newFilePath);
        
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(file));
            PrintWriter pWriter = new PrintWriter(new FileWriter(temp));
            while((line = bReader.readLine())!=null){
                if(!line.trim().equals(details)||!line.trim().equals(detailsTxt)||!line.trim().equals(dateTxt)){
                    pWriter.println(line);
                    pWriter.flush();
                }
            }
            pWriter.close();
            bReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DetailsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!file.delete()){
            System.out.println("Couldn't delete file");
            return;
        }
        if(!temp.renameTo(file)){
            System.out.println("Couldn't rename temp");
        }
    }   
    */
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
