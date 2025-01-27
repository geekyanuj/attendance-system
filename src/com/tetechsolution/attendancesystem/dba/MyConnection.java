package com.tetechsolution.attendancesystem.dba;
import java.sql.*;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;


public class MyConnection {
    public static Connection getConnection() throws InterruptedException{
          Connection connection =null;
           try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","Root@123");
            
        } catch (Exception e){
            Notifications.create().position(Pos.TOP_RIGHT).text("Problem while Connecting to database").title("Error Occurred in MyConnection Class").showError();
            Thread.sleep(3000);
        }
        return connection;
    }
 
}
