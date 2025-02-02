package org.example;

import jakarta.inject.Inject;
import org.example.entity.dto.PersonnelDTO;
import org.example.exception.DuplicateDataException;
import org.example.exception.SaveRecordException;
import org.example.service.PersonnelService;

import java.util.Scanner;

public class Main {

    @Inject
    PersonnelService personnelService;

    public void run() throws SaveRecordException, DuplicateDataException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Personnel and Leave Management ===");

        scanner.nextLine();

        System.out.println("** Enter Personnel Information **");
        System.out.print("Enter your username: ");
        String userName = scanner.nextLine();
        System.out.print("** Enter your password: ");
        String password = scanner.nextLine();
        System.out.print("Enter your mobile number: ");
        String mobile = scanner.nextLine();
        System.out.print("Enter your personnel code: ");
        long personnelCode = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        PersonnelDTO personnel = new PersonnelDTO();
        personnel.setUsername(userName);
        personnel.setPassword(password);
        personnel.setMobile(mobile);
        personnel.setEmail(email);
        personnel.setPersonnelCode(personnelCode);

        personnelService.create(personnel);
    }

    public static void main(String[] args) throws SaveRecordException, DuplicateDataException {
      new Main().run();
    }
}





