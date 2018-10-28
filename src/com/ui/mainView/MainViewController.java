package com.ui.mainView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    Label title;

    @FXML
    Label welcomMsg;

    @FXML
    Button btnUsers, btnExit;

    public void handleBtnUsers(ActionEvent event) throws IOException
    {
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("../login/UsersUi.fxml")),600,400);
        Stage stage = (Stage)btnUsers.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void handleBtnStudents(ActionEvent ev)throws IOException
    {
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("../login/Students.fxml")),600,400);
        Stage stage = (Stage)btnUsers.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    public void close()
    {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,"Are your sure?");
        confirm.setTitle("Exit Xstudent!");
        Optional<ButtonType> result = confirm.showAndWait();

        if (result.get() == ButtonType.OK){
            System.exit(0);

        }else {
            confirm.close();
        }
        //System.exit(0);
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
