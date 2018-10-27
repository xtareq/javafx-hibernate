package com.ui.login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class AddUserController {

    @FXML
    Button btnClose;

    public void close() {
        btnClose.getScene().getWindow().hide();
    }
}
