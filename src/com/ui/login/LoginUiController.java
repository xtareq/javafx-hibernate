package com.ui.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginUiController implements Initializable {

    @FXML
    Label lblMsg;

    @FXML
    TextField txtUsername;

    @FXML
    PasswordField txtPassword;

    @FXML
    Button btnLogin,btnClose;


    //Handaling action on login button click
    public void handelBtnLogin(ActionEvent event)throws IOException
    {

        if (validate()==true){
            login();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Username or Password field can't be empty!");
            alert.setTitle("Invalid or Empty Input!");
            alert.showAndWait();
            txtUsername.setText("");
            txtPassword.setText("");
        }

    }


    //performing login process
    public void login() throws IOException
    {

        if (txtUsername.getText().equals("user") && txtPassword.getText().equals("pass"))
        {
            Scene scene = new Scene((Parent)FXMLLoader.load(getClass().getResource("../mainView/MainView.fxml")),600,400);
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }else{
            lblMsg.setText("Username or Password Incorrect!");
            Alert alert = new Alert(Alert.AlertType.ERROR,"Incorrect username or password!");
            alert.setTitle("Invalid Login!");
            alert.show();
            txtUsername.setText("");
            txtPassword.setText("");

        }
    }


    //input validation
    public boolean validate()
    {
        if (txtUsername.getText().equals("") || txtPassword.getText().equals("")){
            System.out.println("err");
            return false;
        }else {
            return true;
        }
    }


    public void handleBtnClose(ActionEvent ev)
    {
        btnClose.getScene().getWindow().hide();
    }

    //Handaling Action on keyboard enter key on password field

    public void handleOnEnter(ActionEvent e) throws IOException
    {
        if (validate()==true){
            login();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Username or Password field can't be empty!");
            alert.setTitle("Invalid or Empty Input!");
            alert.showAndWait();
            txtUsername.setText("");
            txtPassword.setText("");
        }

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
