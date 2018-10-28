package com.ui.login;

import com.db.StudentManager;
import com.models.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {
    @FXML
    Button btnBack, btnAddUser,btnReload;

    @FXML
    TableView<Student> tblStudents;

    @FXML
    TableColumn colId,colName,colClass,colRoll;

    public  StudentsController()
    {
        System.out.println("working");
    }

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

    public void handleBtnReload(ActionEvent ev) throws IOException
    {
        //colId.setCellValueFactory(new Property(s));
        //colId.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
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
            colId.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
            colClass.setCellValueFactory(new PropertyValueFactory<Student, String>("classNname"));
            colRoll.setCellValueFactory(new PropertyValueFactory<Student, Integer>("roll"));
            //tblStudents.setItems(loadStudents());
    }

    public ObservableList<Student> loadStudents()
    {
        ObservableList<Student> studentsArray = FXCollections.observableArrayList();
        StudentManager sm = new StudentManager();
        List<Student> students = sm.fetchAll();

        for (Student std:students)
        {
            studentsArray.add(std);
        }

        return studentsArray;
    }
}
