package com.tetechsolution.attendancesystem.controller;

import com.tetechsolution.attendancesystem.beans.EntryData;
import com.tetechsolution.attendancesystem.services.attendanceServicesImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author anujv
 */
public class HomeController implements Initializable {

    attendanceServicesImpl attendanceServicesImpl;

    @FXML
    private JFXButton reportNavBtn;
    @FXML
    private JFXButton calNavBtn;
    @FXML
    private JFXButton dailyTrackerNavBtn;
    @FXML
    private TextField searchTf;
    @FXML
    private JFXButton searchBtn;
    @FXML
    private TableView<EntryData> tableView;
    @FXML
    private TableColumn<EntryData, Integer> idCol;
    @FXML
    private TableColumn<EntryData, String> nameCol;
    @FXML
    private TableColumn<EntryData, String> inTimeCol;
    @FXML
    private TableColumn<EntryData, String> outTimeCol;
    @FXML
    private TableColumn<?, ?> MidDayCol;
    @FXML
    private TableColumn<?, ?> statusCol;
    @FXML
    private MenuButton classMenuBtn;
    @FXML
    private ComboBox<String> filterComboBtn;
    @FXML
    private JFXDatePicker datepicker;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        attendanceServicesImpl = new attendanceServicesImpl();
//        feedTableData();
//        loadClasses();
//         loadFilterPresent();
        loadDatePicker();

          
    }

    

   
    
    void feedTableData(){
        
        List<EntryData> tabledata = attendanceServicesImpl.getAllData();
        ObservableList<EntryData> data = FXCollections.observableArrayList(tabledata);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        inTimeCol.setCellValueFactory(new PropertyValueFactory<>("inTime"));
        outTimeCol.setCellValueFactory(new PropertyValueFactory<>("outTime"));
        MidDayCol.setCellValueFactory(new PropertyValueFactory<>("middayleave"));

        tableView.getItems().addAll(data);
    }
    void loadClasses(){
        // Generate 12 classes dynamically
        for (int i = 1; i <= 12; i++) {
            // Create a Menu for each class
            Menu classMenu = new Menu("Class " + i);

            // Add sections A, B, C for each class
            for (char section = 'A'; section <= 'C'; section++) {
                MenuItem sectionItem = new MenuItem("Section " + section);
                
                // Add action to each section
                sectionItem.setOnAction(e -> System.out.println(classMenu.getText() + " - " + sectionItem.getText() + " selected"));
                
                // Add the section to the class menu
                classMenu.getItems().add(sectionItem);
            }

            // Add the class menu to the MenuButton
            classMenuBtn.getItems().add(classMenu);
        }
    }
    void loadFilterPresent(){
        filterComboBtn.getItems().addAll("Present","Absent","Leave");
    }
    void loadDatePicker(){
        
        
        datepicker.setValue(LocalDate.now());
        
        datepicker.setDayCellFactory(picker -> new javafx.scene.control.DateCell() {
            @Override
            public void updateItem(java.time.LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                // Disable future dates
                if (item.isAfter(java.time.LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #e0e0e0; -fx-text-fill: #b0b0b0;");
                }
            }
        });
    }

    @FXML
    private void prevDate(ActionEvent event) {
        datepicker.setValue(datepicker.getValue().minusDays(1));
    }

    @FXML
    private void nextDate(ActionEvent event) {
        if(!datepicker.getValue().equals(LocalDate.now())){
            datepicker.setValue(datepicker.getValue().plusDays(1));
        }
        
    }


}
