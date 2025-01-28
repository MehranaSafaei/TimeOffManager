package org.example.service;

import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import org.example.dao.PersonnelDao;
import org.example.entity.Personnel;

import java.io.Serializable;
import java.util.Optional;

@Stateless
@LocalBean
public class PersonnelService implements Serializable {


    @Inject
    private PersonnelDao personnelDao;

    public void createPersonnel(Personnel personnel) {
      try {
          personnelDao.insert(personnel);
      }catch(Exception e) {
          e.printStackTrace();
      }
    }


//    public Optional<Personnel> findByRole(Role role) {
//        return personnelDao.findAll().stream()
//                .filter(personnel -> personnel.getRole().equals(role))
//                .findFirst();
//    }

    public Personnel getPersonnelById(Long leavePersonnelId) {
        Optional<Personnel> personnelOptional = personnelDao.getById(leavePersonnelId);
        return personnelOptional.orElse(null);
    }
//
//    public Personnel findPersonnelByCode(long personnelCodeForLeave) {
//        Optional<Personnel> personnelOptional = personnelDao.findAll().stream()
//                .filter(personnel -> personnel.getPersonnelCode() == personnelCodeForLeave)
//                .findFirst();
//        return personnelOptional.orElse(null);
//    }

    public PersonnelDao getPersonnelDao() {
        return personnelDao;
    }

    public void setPersonnelDao(PersonnelDao personnelDao) {
        this.personnelDao = personnelDao;
    }
}
