package org.example.service;

import jakarta.inject.Inject;
import org.example.dao.LeaveDao;
import org.example.entity.Leave;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LeaveService {

    @Inject
    private LeaveDao leaveDao;
    @Inject
    private PersonnelService personnelService;


//    public Leave createLeave(Leave leave)  {
//        Optional<Leave> createdLeave = leaveDao.insert(leave);
//        return createdLeave.orElse(null);
//    }

    public List<Leave> findAll() throws SQLException {
        return leaveDao.findAll();
    }
}
