package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.entity.Leave;
import org.example.entity.Personnel;
import org.example.entity.dto.PersonnelDTO;
import org.example.enums.LeaveType;
import org.example.service.LeaveService;
import org.example.service.PersonnelService;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

@ApplicationScoped
public class Main {

    @Inject
    private PersonnelService personnelService;

    @Inject
    private LeaveService leaveService;

    public void run() {
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

                    if (createdPersonnel.isPresent()) {
                        System.out.println("Personnel Created: " +
                                createdPersonnel.get().getUsername() + " - " +
                                createdPersonnel.get().getMobile() + " - " +
                                createdPersonnel.get().getPersonnelCode() + " - " +
                                createdPersonnel.get().getEmail());
                    } else {
                        System.out.println("Personnel creation failed.");
                    }
                    break;

                case 2:
//                    System.out.print("Enter Personnel Code to apply for leave: ");
//                    long personnelCodeForLeave = scanner.nextLong();
//                    scanner.nextLine();
//
////                    Optional<Personnel> personnelForLeave = personnelService.findPersonnelByCode(personnelCodeForLeave);
//
//                    if (personnelForLeave.isEmpty()) {
//                        System.out.println("Personnel not found.");
//                        break;
//                    }
//
//                    Personnel p = personnelForLeave.get();
//                    System.out.println("Personnel found: " + p.getUsername());
//
//                    System.out.println("Enter leave details:");
//                    System.out.print("Enter start date (YYYY-MM-DD): ");
//                    String startDate = scanner.nextLine();
//                    System.out.print("Enter end date (YYYY-MM-DD): ");
//                    String endDate = scanner.nextLine();
//                    System.out.print("Enter description: ");
//                    String description = scanner.nextLine();
//
//                    System.out.print("Enter Leave Type (ANNUAL, SICK, UNPAID, MATERNITY): ");
//                    LeaveType leaveType = LeaveType.valueOf(scanner.nextLine().toUpperCase());
//
//                    Leave leave = new Leave();
//                    leave.setStartDate(LocalDate.parse(startDate));
//                    leave.setEndDate(LocalDate.parse(endDate));
//                    leave.setDescription(description);
//                    leave.setLeaveType(leaveType);
//                    leave.setPersonnel(p);
//
//                    Optional<Leave> createdLeave = leaveService.createLeave(leave);
//
//                    if (createdLeave.isPresent()) {
//                        System.out.println("Leave Created: " +
//                                createdLeave.get().getStartDate() + " - " +
//                                createdLeave.get().getEndDate() + " - " +
//                                createdLeave.get().getDescription() + " - " +
//                                createdLeave.get().getLeaveType());
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

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
}
