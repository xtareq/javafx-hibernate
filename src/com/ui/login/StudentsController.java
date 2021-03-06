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
    TableColumn<Student, Integer> colId;

    @FXML

    TableColumn colClass,colRoll;

    @FXML
    TableColumn<Student, String> colName;
    public  StudentsController()
    {
        System.out.println("working");
    }

    public void handleBtnBack(ActionEvent event) throws IOException
    {
        try {
            Scene scene = new Scene((Parent) FXMLLoader.load(getClass()
                    .getResource("../mainView/MainView.fxml")));
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    //handle Delete Button

    public void handleBtnDelete(ActionEvent ev) throws IOException
    {

         Object selectedItems = tblStudents.getSelectionModel().getSelectedItem().getId();
           // tblStudents.getRowFactory().call(selectedItems)

        tblStudents.getItems().removeAll(tblStudents.getSelectionModel().getSelectedItem());
         try {
             StudentManager.delete(((Long) selectedItems).longValue());
         }catch (Exception e)
         {
             e.printStackTrace();
         }
         refreshStudentsTable();
    }

    public void handleBtnAddUser(ActionEvent event) throws IOException
    {

        try {
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

        }catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            refreshStudentsTable();
        }

    }

    public void handleBtnReload(ActionEvent ev) throws IOException
    {
      refreshStudentsTable();
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
    public void initialize(URL location, ResourceBundle resources)
    {
            tblStudents.refresh();
            colId.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
            colClass.setCellValueFactory(new PropertyValueFactory<Student, String>("class_name"));
            colRoll.setCellValueFactory(new PropertyValueFactory<Student, Integer>("roll"));
            //tblStudents.setItems(loadStudents());
            refreshStudentsTable();
    }

    public void refreshStudentsTable()
    {
        tblStudents.getItems().clear();
        tblStudents.setItems(loadStudents());

    }

    public ObservableList<Student> loadStudents()
    {
        ObservableList<Student> studentsArray = FXCollections.observableArrayList();
        StudentManager sm = new StudentManager();
        List<Student> students;
        students = sm.fetchAll();

        for (Student std:students)
        {
            studentsArray.add(std);
        }
        return studentsArray;
    }

}
