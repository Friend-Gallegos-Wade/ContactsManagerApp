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



        while (true) {
            System.out.println("1. View Contacts \n2. Add new contact \n3. Search contact by name \n4. Delete an existing contact. \n5. Exit \nEnter an option (1, 2, 3, 4, or 5)");

            Integer input = scn.nextInt();
            if (input == 1) {
                try {
                    Lines = Files.readAllLines(filepath);
                    for (String Line : Lines) {
                        contactsList.add(new Contacts());
                        if (Line.equalsIgnoreCase("")) {
                            continue;
                        }
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
                    String contactFormat = String.format("%s: %s-%s-%s", contactName, contactNumber.substring(0, 3), contactNumber.substring(3, 6), contactNumber.substring(6, 10));
                    Files.write(filepath, Arrays.asList(contactFormat), StandardOpenOption.APPEND);
                    Lines.add(contactFormat);
                    contactsList.add(new Contacts(contactName, contactNumber));
//                for (Contacts contact: contactsList) {
//                    System.out.println(contact);
//                }
                } catch (IOException o) {
                    o.printStackTrace();
                }
            }
            if (input == 3) {
                try {
                    Lines = Files.readAllLines(filepath);
                    System.out.println("Enter the name you'd like to search");
                    scn.nextLine();
                    String nameSearch = scn.nextLine();
                    for (String Line : Lines) {
                        contactsList.add(new Contacts());
                        if (Line.contains(nameSearch) == true) {
                            System.out.println(Line);
                        }
                    }
                } catch (IOException o) {
                    o.printStackTrace();
                }
            }
            if (input == 4) {
                try {
                    Lines = Files.readAllLines(Paths.get("data", "contacts.txt"));
                    List<String> newList = new ArrayList<>();
                    System.out.println("Enter a contact you'd like to delete");
                    scn.nextLine();
                    String deleteName = scn.nextLine();
                    for (String Line : Lines) {
                        if (Line.contains(deleteName) == true) {
                            newList.add("");
                            continue;
                        }
                        newList.add(Line);
                    }
                    Files.write(Paths.get("data", "contacts.txt"), newList);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (input == 5) {
                break;
            }
            System.out.println("Would you like to select another option? [Y/N]");
            String decision = scn.next();
            if (decision.equalsIgnoreCase("n")){
                break;
            }
        }
    }
}