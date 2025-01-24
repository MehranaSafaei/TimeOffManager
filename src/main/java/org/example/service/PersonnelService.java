package org.example.service;

import jakarta.enterprise.context.RequestScoped;
import org.example.dao.PersonnelDao;
import org.example.entity.Personnel;
import org.example.enums.Role;
import jakarta.inject.Inject;

import java.util.Optional;

@RequestScoped
public class PersonnelService {

    @Inject
    private PersonnelDao personnelDao;

    public Personnel createPersonnel(Personnel personnel) {
        Personnel personnel1 = new Personnel();
        personnel1.setUsername(personnel.getUsername());
        personnel1.setMobile(personnel.getMobile());
        personnel1.setEmail(personnel.getEmail());
        personnel1.setPersonnelCode(personnel.getPersonnelCode());
        personnel1.setRole(Role.valueOf(personnel.getRole().toString()));

        return personnelDao.insert(personnel1).orElse(null);
    }

    public Optional<Personnel> findByRole(Role role) {
        return personnelDao.findAll().stream()
                .filter(personnel -> personnel.getRole().equals(role))
                .findFirst();
    }

    public Personnel getPersonnelById(Long leavePersonnelId) {
        Optional<Personnel> personnelOptional = personnelDao.getById(leavePersonnelId);
        return personnelOptional.orElse(null);
    }

    public Personnel findPersonnelByCode(long personnelCodeForLeave) {
        Optional<Personnel> personnelOptional = personnelDao.findAll().stream()
                .filter(personnel -> personnel.getPersonnelCode() == personnelCodeForLeave)
                .findFirst();
        return personnelOptional.orElse(null);
    }
}
