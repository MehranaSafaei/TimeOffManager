package org.example.dao;


import jakarta.persistence.EntityManager;
import org.example.controller.request.RequestDto;
import org.example.entity.Leave;
import org.example.entity.Personnel;
import org.example.entity.dto.LeaveDTO;
import org.example.entity.dto.PersonnelDTO;

public class LeaveDAO {

    private EntityManager entityManager;
    private PersonnelDAO personnelDAO;

    public Leave createLeave(Leave leave) {
        try {
            if (leave.getPersonnel().getId() != null) {
                entityManager.getTransaction().begin();
                entityManager.persist(leave);
            }
        }
    }

}
