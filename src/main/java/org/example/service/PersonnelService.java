package org.example.service;

import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.dao.PersonnelDao;
import org.example.entity.Personnel;
import org.example.entity.dto.PersonnelDTO;
import org.example.exception.DuplicateDataException;
import org.example.exception.SaveRecordException;

import java.io.Serializable;

@Stateless
public class PersonnelService implements Serializable {

    @Inject
    private PersonnelDao personnelDao;

    /*@Transactional
    public void create(Personnel personnelDTO) {
        if (personnelDTO == null) {
            throw new IllegalArgumentException("PersonnelDTO cannot be null");
        }

        Personnel personnel = new Personnel();
        personnel.setId(personnelDTO.getId());
        personnel.setMobile(personnelDTO.getMobile());
        personnel.setPersonnelCode(personnelDTO.getPersonnelCode());
        personnel.setEmail(personnelDTO.getEmail());
        personnel.setUsername(personnelDTO.getUsername());

        personnelDao.create(personnel);
    }*/
    private boolean canSavePersonnel(Personnel personnel) throws DuplicateDataException {
        if(personnelDao.countPersonnelByCode(personnel.getPersonnelCode())==0L){
         return true;
        }else {
            throw new DuplicateDataException();
        }
    }
    
    @Transactional
    public void createPersonnel(Personnel personnel) throws SaveRecordException, DuplicateDataException {
        if (canSavePersonnel(personnel)) {
            personnelDao.create(personnel);
        }else {
            throw new SaveRecordException();
        }
    }
    
    //TODO:THINK
    private Personnel BuildPersonnel(PersonnelDTO personnelDTO) {
        Personnel personnel = new Personnel();
        personnel.setId(personnelDTO.getId());
        personnel.setMobile(personnelDTO.getMobile());
        personnel.setPersonnelCode(personnelDTO.getPersonnelCode());
        personnel.setEmail(personnelDTO.getEmail());
        personnel.setUsername(personnelDTO.getUsername());
        return personnel;
    }

    public void create(PersonnelDTO personnelDTO) throws DuplicateDataException {
        Personnel personnel = BuildPersonnel(personnelDTO);
        personnel.setId(null);
        canSavePersonnel(personnel);
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

