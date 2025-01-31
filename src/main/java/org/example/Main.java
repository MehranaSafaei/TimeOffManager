package org.example;

import com.mysql.cj.protocol.a.authentication.AuthenticationOciClient;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Inject;
import org.example.entity.dto.PersonnelDTO;
import org.example.exception.DuplicateDataException;
import org.example.exception.SaveRecordException;
import org.example.service.PersonnelService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.util.Scanner;
@ApplicationScoped
public class Main {

    @Inject
    private PersonnelService personnelService;

    public void run() throws SaveRecordException, DuplicateDataException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Personnel and Leave Management ===");

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
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        Main main = container.select(Main.class).get();
        main.run();

        container.shutdown();
    }
}

