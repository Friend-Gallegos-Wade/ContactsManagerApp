package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactFileIO {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Path filepath = Paths.get("data", "contacts.txt");
        List<String> Lines;
        List<Contacts> contactsList = new ArrayList<>();
        System.out.println("1. View Contacts \n2. Add new contact \n3. Search contact by name \n4. Delete an existing contact. \n5. Exit \nEnter an option (1, 2, 3, 4, or 5)");

        Integer input = scn.nextInt();
        if (input == 1) {
            try {
                Lines = Files.readAllLines(filepath);
                for (String Line : Lines) {
                    contactsList.add(new Contacts());
                    System.out.println(Line);
                }
            } catch (IOException i) {
                throw new RuntimeException(i);
            }
        }
        if (input == 2) {
            try {
                Lines = Files.readAllLines(filepath);
                System.out.println("Enter contact name");
                scn.nextLine();
                String contactName = scn.nextLine();
                System.out.println("Enter contact number");
                String contactNumber = scn.nextLine();
                String contactFormat = String.format("%s: %s", contactName, contactNumber);
                Files.write(filepath, Arrays.asList(contactFormat), StandardOpenOption.APPEND);
                Lines.add(contactFormat);
                contactsList.add(new Contacts(contactName, contactNumber));
                for (Contacts contact: contactsList) {
                    System.out.println(contact);
                }
            } catch (IOException o) {
                o.printStackTrace();
            }
        }
        if (input == 3) {
            try {
                Lines = Files.readAllLines(filepath);
                System.out.println("Enter the name you'd like to search");
                scn.nextLine();
            }
        }
    }
}