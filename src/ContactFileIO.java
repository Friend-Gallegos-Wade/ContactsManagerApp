package src;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactFileIO {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        Path filepath = Paths.get("data", "contacts.txt");
        List<String> Lines;
        List<Contacts> contactsList = new ArrayList<>();
        System.out.println("1. View Contacts \n2. Add new contact \n3. Search contact by name \n4. Delete an existing contact. \n5. Exit \nEnter an option (1, 2, 3, 4, or 5)");

        try {
            Lines = Files.readAllLines(filepath);
            Contacts Cynthia = new Contacts("Cynthia", "1234567");
        } for (String Line : Lines) {
            contactsList.add(new Contacts());
        }
    }

}
