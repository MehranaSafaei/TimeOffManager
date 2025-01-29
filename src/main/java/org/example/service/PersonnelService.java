package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.dao.PersonnelDao;
import org.example.entity.Personnel;

import java.io.Serializable;

@ApplicationScoped
public class PersonnelService implements Serializable {
    @Inject
    private PersonnelDao personnelDao;

    @Transactional
    public void create(Personnel personnelDTO) {
        if (personnelDTO == null) {
            throw new IllegalArgumentException("PersonnelDTO cannot be null");
        }

        Personnel personnel = new Personnel();
        personnel.setMobile(personnelDTO.getMobile());
        personnel.setPersonnelCode(personnelDTO.getPersonnelCode());
        personnel.setEmail(personnelDTO.getEmail());
        personnel.setUsername(personnelDTO.getUsername());

        personnelDao.create(personnel);
    }


//    public Personnel getPersonnelById(Long leavePersonnelId) {
//        return personnelDao.getById(leavePersonnelId).orElse(null);
//    }
//
//    public Optional<Personnel> findByRole(Role role) {
//        return personnelDao.findByRole(role);
//    }
//
//    public Optional<Personnel> findPersonnelByCode(long personnelCode) {
//        return personnelDao.findByPersonnelCode(personnelCode);
//    }
}


//    public Personnel findPersonnelByCode(long personnelCodeForLeave) {
//        Optional<Personnel> personnelOptional = personnelDao.findAll().stream()
//                .filter(personnel -> personnel.getPersonnelCode() == personnelCodeForLeave)
//                .findFirst();
//        return personnelOptional.orElse(null);
//    }

