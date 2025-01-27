
package com.tetechsolution.attendancesystem.beans;

import java.sql.Date;

/**
 *
 * @author anujv
 */
public class EntryData {
    private int id;
    private String name;
    private String inTime;
    private String outTime;
    private String middayleave;

    public EntryData() {
    }

    
    public EntryData(int id, String name, String inTime, String outTime, String middayleave) {
        this.id = id;
        this.name = name;
        this.inTime = inTime;
        this.outTime = outTime;
        this.middayleave = middayleave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getMiddayleave() {
        return middayleave;
    }

    public void setMiddayleave(String middayleave) {
        this.middayleave = middayleave;
    }
    
    
    
    
    
}
