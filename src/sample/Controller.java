package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    FileChooser fileChooser;

    @FXML
    Button button;

    @FXML
    ImageView imageView;

    public void openFile(ActionEvent event) throws IOException
    {
   /*     HBox hBox = new HBox();
        Scene root = new Scene(hBox, 600,400);
        Stage stage= (Stage)button.getScene().getWindow();
        stage.setScene(root);
        stage.show();
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(stage);
        fc.initialDirectoryProperty();

        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image File","*.jpg,*.png")
        );

        String name =file.getName();
        String aname =file.getAbsoluteFile().getAbsolutePath();
        System.out.println(aname);*/

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        File file = chooser.showOpenDialog(new Stage());
        if(file != null) {
            String imagepath = file.toURI().toURL().toString();
            System.out.println("file:"+imagepath);
            Image image = new Image(imagepath);


            imageView.setImage(image);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Please Select a File");
            /*alert.setContentText("You didn't select a file!");*/
            alert.showAndWait();
        }




    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
