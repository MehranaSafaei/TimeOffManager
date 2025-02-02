package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.dao.GenericDao;
import org.example.dao.PersonnelDao;
import org.example.dao.PersonnelRepo;
import org.example.entity.Personnel;
import org.example.entity.dto.PersonnelDTO;
import org.example.exception.DuplicateDataException;
import org.example.exception.SaveRecordException;

import java.io.Serializable;

@RequestScoped
public class PersonnelService implements Serializable {

    @Inject
    private PersonnelDao personnelDao;

    private boolean canSavePersonnel(Personnel personnel) throws DuplicateDataException {
        /*if(personnelDao.countPersonnelByID(personnel.getPersonnelCode())==0L){
         return true;
        }else {
            throw new DuplicateDataException();
        }*/
        return true;
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

    public void create(PersonnelDTO personnelDTO) throws DuplicateDataException, SaveRecordException {
        Personnel personnel = BuildPersonnel(personnelDTO);
        personnel.setId(null);
        createPersonnel(personnel);
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

