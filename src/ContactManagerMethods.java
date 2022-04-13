package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class ContactManagerMethods {
    private final Path contactsPath = Paths.get("data", "Contacts.txt");
    private List<String> contactsData = addToList();

    //populates the contactsList with data from the Contacts.txt file
    protected List<String> addToList(){
        try {
            if (Files.notExists(contactsPath)) Files.createDirectories(contactsPath);
            contactsData = Files.readAllLines(contactsPath);
        } catch(IOException e){
            System.out.println("File or Directory could not be created.");
            e.printStackTrace();
        }
        return contactsData;
    }

    //loops through the contactsData List and displays information to the page
    protected void displayContacts(){
        System.out.println("====================");
        for (String line : contactsData) {
            System.out.println(line);
        }
        System.out.println("====================");
    }

    //writes file using contactsPath and contactsData
    protected boolean writeFile(){
        try {
            Files.write(contactsPath, contactsData);
        } catch(IOException e){
            System.out.println("Error writing this file");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //prompts the user for an input and then adds to the list
    protected List<String> addContact(){
        System.out.println("Please enter your new contacts information.");
        Scanner sc = new Scanner(System.in);
        String newContact = sc.nextLine();
        contactsData.add(newContact);
        writeFile();
        return contactsData;
    }

    //allows the user to search through the list of contacts and display a specific contact to the console
    protected void searchContact() {
        System.out.println("Which contact are you looking for?");
        Scanner sc3 = new Scanner(System.in);
        String searchContact = sc3.nextLine();
        List<String> displayedContact;

        try {
            displayedContact = Files.readAllLines(contactsPath);
            System.out.println("====================");
            int failedTries = 0;

            for (String Line : displayedContact) {
                    if (Line.toLowerCase().contains(searchContact.toLowerCase())) {
                        System.out.println(Line);
                    } else {
                        failedTries++;
                        if(failedTries == displayedContact.size()){
                            System.out.println("Sorry that contact does not exist");
                        }
                    }
                }

            System.out.println("====================");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //allows the user to delete a contact inputted bt the user
    protected void deleteContact() throws IOException {
        System.out.println("Which contact would you like to delete?");
        contactsData = Files.readAllLines(contactsPath);
        Scanner sc = new Scanner(System.in);
        String deletePerson = sc.next();
        contactsData.removeIf(contactsData -> contactsData.toLowerCase().contains(deletePerson.toLowerCase()));
        Files.write(contactsPath, contactsData);
    }
}
