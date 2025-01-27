
package com.tetechsolution.attendancesystem.services;

import com.tetechsolution.attendancesystem.beans.EntryData;
import com.tetechsolution.attendancesystem.repository.attendanceRepoImpl;
import java.util.List;

/**
 *
 * @author anujv
 */

public class attendanceServicesImpl implements attendanceServices{
    
    attendanceRepoImpl attendanceRepoImpl;

    public attendanceServicesImpl() {
        attendanceRepoImpl = new attendanceRepoImpl();
    }

    @Override
    public List<EntryData> getAllData() {
        return attendanceRepoImpl.getAllData();
    }
    
}
