package org.example;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;

import java.io.Serializable;
import java.util.Optional;
import java.util.Scanner;

import org.example.exception.DuplicateDataException;
import org.example.exception.SaveRecordException;
import org.example.service.PersonnelService;
import org.example.entity.Personnel;
import org.example.entity.dto.PersonnelDTO;

public class Main {

    @EJB
    private PersonnelService personnelService;

    public void run() throws SaveRecordException, DuplicateDataException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Personnel and Leave Management ===");

            /*System.out.println("1. Create Personnel");
            System.out.println("2. Exit");*/
        /*int choice = scanner.nextInt();*/
        scanner.nextLine();

        System.out.println("** Enter Personnel Information **");
        System.out.print("Enter your username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter your mobile number: ");
        String mobile = scanner.nextLine();
        System.out.print("Enter your personnel code: ");
        long personnelCode = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        PersonnelDTO personnel = new PersonnelDTO();
        personnel.setUsername(userName);
        personnel.setMobile(mobile);
        personnel.setEmail(email);
        personnel.setPersonnelCode(personnelCode);


        personnelService.create(personnel);
    }


    public static void main(String[] args) throws SaveRecordException, DuplicateDataException {
        Main main = new Main();
        main.run();
    }
}
