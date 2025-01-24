//package org.example.bean;
//
//import jakarta.enterprise.context.RequestScoped;
//import jakarta.inject.Inject;
//import jakarta.inject.Named;
//import org.example.entity.Personnel;
//import org.example.entity.dto.PersonnelDTO;
//import org.example.service.PersonnelService;
//
//import java.util.List;
//
//@Named("personnelBean")
//@RequestScoped
//public class PersonnelManagedBean {
//
//    @Inject
//    private PersonnelService personnelService;
//
//    private Personnel personnel = new Personnel();
//
//    public void save() {
//        personnelService.addPersonnel(personnel);
//    }
//
//    public Personnel getPersonnel() {
//        return personnel;
//    }
//
//    public void setPersonnel(Personnel personnel) {
//        this.personnel = personnel;
//    }
//
//    public List<PersonnelDTO> getAllPersonnel() {
//        return personnelService.getAllPersonnel();
//    }
//}
