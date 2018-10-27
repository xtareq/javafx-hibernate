package com.ui.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class StudentsController {
    @FXML
    Button btnBack, btnAddUser;

    public void handleBtnBack(ActionEvent event) throws IOException
    {
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("../mainView/MainView.fxml")),600,400);
        Stage stage = (Stage)btnBack.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void handleBtnAddUser(ActionEvent event) throws IOException
    {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("AddStudent.fxml"));
        //loader.setController(new AddUserController());
        final Parent root = loader.load();
        final Scene scene = new Scene(root, 400, 500);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initOwner(btnAddUser.getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

}
