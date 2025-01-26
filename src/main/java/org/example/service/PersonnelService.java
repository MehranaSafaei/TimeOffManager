package org.example.service;

import jakarta.inject.Inject;
import org.example.dao.PersonnelDao;
import org.example.entity.Personnel;
import org.example.entity.dto.PersonnelDTO;
import org.example.enums.Role;
import org.example.mapper.DtoMapper;

import java.util.Optional;


public class PersonnelService {


    @Inject
    private PersonnelDao personnelDao;

    public Optional<PersonnelDTO> createPersonnel(Personnel personnel) {
        try {
            if (personnelDao == null) {
                throw new IllegalStateException("PersonnelDAO is not injected");
            }

            Personnel savedPersonnel = personnelDao.insert(personnel);

            PersonnelDTO personnelDTO = DtoMapper.entityToDTO(savedPersonnel);

            return Optional.of(personnelDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
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
