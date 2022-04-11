package src;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class ContactManagerMethods {
    public Path contactsPath = Paths.get("data", "Contacts.txt");
    List<String> contactsData = addToList();

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
    public boolean writeFile(){
        try {
            Files.write(contactsPath, contactsData);
        } catch(IOException e){
            System.out.println("Error writing this file");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    protected List<String> addContact(String newContact){
        contactsData.add(newContact);
        writeFile();
        return contactsData;
    }

    public void searchContact() {
        Scanner sc3 = new Scanner(System.in);
        String searchContact = sc3.nextLine();
        List<String> displayedContact = null;
        try {
            displayedContact = Files.readAllLines(contactsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String Line : displayedContact) {
            if (Line.toLowerCase().contains(searchContact)) {
                System.out.println(Line);
            }
        }
    }

    public void deleteContact() throws IOException {
        contactsData = Files.readAllLines(contactsPath);

        Scanner sc = new Scanner(System.in);
        String deletePerson = sc.next();

        contactsData.removeIf(contactsData -> contactsData.toLowerCase().contains(deletePerson.toLowerCase()));

        Files.write(contactsPath, contactsData);
    }

}
