package com.ui.login;

import com.db.StudentManager;
import com.models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.event.spi.SaveOrUpdateEventListener;

public class AddStudentController {
    @FXML
    Button btnClose,btnSave,btnReset;

    @FXML
    TextField txtName,txtClassName,txtRoll;

    public void close() {
        btnClose.getScene().getWindow().hide();
    }

    public void handleBtnReset(ActionEvent ev) {
        clearInput();
    }

    public void clearInput()
    {
        txtName.setText("");
        txtClassName.setText("");
        txtRoll.setText("");
    }

    public void handleBtnSave()
    {
        //do validation
        //do save

        Student std = new Student();
        std.setName(txtName.getText());
        std.setClass_name(txtClassName.getText());
        std.setRoll(Integer.parseInt(txtRoll.getText()));
        StudentManager sm = new StudentManager();
        sm.create(std);
        Alert save = new Alert(Alert.AlertType.INFORMATION,"Student Saved Successfully!");
        save.show();
        clearInput();
        this.close();

    }
}
