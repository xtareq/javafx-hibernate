package com.ui;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Loader implements Initializable {


    public void load(String name) throws IOException
    {
        try {
            Scene scene = new Scene((Parent) FXMLLoader.load(getClass()
                    .getResource(name)));
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
