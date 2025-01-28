package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import org.example.dao.PersonnelDao;
import org.example.entity.Personnel;
import org.example.entity.dto.PersonnelDTO;
import org.example.mapper.DtoMapper;

import java.io.Serializable;
import java.util.Optional;

@SessionScoped
public class PersonnelService implements Serializable {
    @Inject
    private PersonnelDao personnelDao;

    public Optional<PersonnelDTO> createPersonnel(Personnel personnel) {
        try {
            if (personnelDao == null) {
                throw new IllegalStateException("PersonnelDAO is not injected");
            }
            Personnel savedPersonnel = personnelDao.insert(personnel);
            PersonnelDTO personnelDTO = DtoMapper.entityToDTO(savedPersonnel);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

