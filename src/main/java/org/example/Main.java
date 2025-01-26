package org.example;

import jakarta.enterprise.context.RequestScoped;
import org.example.entity.Leave;
import org.example.entity.Personnel;
import org.example.entity.dto.LeaveDTO;
import org.example.entity.dto.PersonnelDTO;
import org.example.enums.LeaveType;
import org.example.enums.Role;
import org.example.service.LeaveService;
import org.example.service.PersonnelService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

@RequestScoped
public class Main {
    public static void main(String[] args) {
        PersonnelService personnelService = new PersonnelService();
        LeaveService leaveService = new LeaveService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Personnel and Leave Management ===");

        while (true) {
            System.out.println("1. Create Personnel");
            System.out.println("2. Create Leave");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
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


                    Personnel personnel = new Personnel();
                    personnel.setUsername(userName);
                    personnel.setMobile(mobile);
                    personnel.setEmail(email);
                    personnel.setPersonnelCode(personnelCode);


                    Optional<PersonnelDTO> createdPersonnel = personnelService.createPersonnel(personnel);
                    System.out.println("Created Personnel: " + createdPersonnel.get().getUsername());
                    if (createdPersonnel != null) {
                        System.out.println("Personnel Created: " + createdPersonnel.get().getUsername() + " - " + createdPersonnel.get().getMobile() + " - " + createdPersonnel.get().getPersonnelCode() + " - " + createdPersonnel.get().getEmail());
                    } else {
                        System.out.println("Personnel creation failed.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Personnel Code to apply for leave: ");
                    long personnelCodeForLeave = scanner.nextLong();
                    scanner.nextLine();

                    Personnel p = personnelService.findPersonnelByCode(personnelCodeForLeave);
                    if (p == null) {
                        System.out.println("Personnel not found.");
                        break;
                    }

                    LocalDateTime loginTime = LocalDateTime.now();
                    System.out.println("Login time: " + loginTime);

                    System.out.println("Enter leave details:");
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    String endDate = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter Leave Type (ANNUAL, SICK, UNPAID, MATERNITY): ");
                    LeaveType leaveType = LeaveType.valueOf(scanner.nextLine().toUpperCase());

                    Leave leave = new Leave();
                    leave.setStartDate(LocalDate.parse(startDate));
                    leave.setEndDate(LocalDate.parse(endDate));
                    leave.setDescription(description);
                    leave.setLeaveType(leaveType);
                    leave.setPersonnel(p);
//                    leave.setLoginTime(loginTime);

//                    Leave createdLeave = leaveService.createLeave(leave);
//                    if (createdLeave != null) {
//                        System.out.println("Leave Created: " + createdLeave.getStartDate() + " - " + createdLeave.getEndDate() + " - " + createdLeave.getDescription() + " - " + createdLeave.getLeaveType());
//                    } else {
//                        System.out.println("Leave creation failed.");
//                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
