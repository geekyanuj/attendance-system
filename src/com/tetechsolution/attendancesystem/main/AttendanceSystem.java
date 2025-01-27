
package com.tetechsolution.attendancesystem.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author anujv
 */
public class AttendanceSystem extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("/com/tetechsolution/attendancesystem/view/Home.fxml"));
        stage.setResizable(false);
        stage.setTitle("Attendance System - TETechsolution v1.1.1");
        stage.getIcons().add(new Image("/com/tetechsolution/attendancesystem/view/img/tetechlogo.png"));
        Scene scene=new Scene(root,1366, 768);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
