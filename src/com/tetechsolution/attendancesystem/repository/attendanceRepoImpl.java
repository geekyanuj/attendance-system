
package com.tetechsolution.attendancesystem.repository;

import com.tetechsolution.attendancesystem.beans.EntryData;
import com.tetechsolution.attendancesystem.dba.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

/**
 *
 * @author anujv
 */
public class attendanceRepoImpl implements attendanceRepo{

    @Override
    public List<EntryData> getAllData() {
        Connection connection=null;
        List<EntryData> entryDataList = new ArrayList<>();
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM entry");

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                EntryData data=new EntryData();
                data.setId(rs.getInt(1));
                data.setName(rs.getString(2));
                data.setInTime(rs.getDate(3)+"");
                data.setOutTime(rs.getDate(4)+"");
                data.setMiddayleave(rs.getString(5));
                
                entryDataList.add(data);
            
            }
            rs.close();
            ps.close();
            
        } catch (Exception e){
            e.printStackTrace();
            Notifications.create().darkStyle().position(Pos.TOP_LEFT).title("Error Occured while Connecting to DB").showError();
        }
    return entryDataList;
    }
    
}
