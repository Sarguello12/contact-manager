package src;

import java.io.IOException;
import java.util.Scanner;

public class ContactManagerMain{
    public static void main(String[] args) throws IOException{
        //instantiates ContactManagerMethods for the utility functions
        ContactManagerMethods utilities = new ContactManagerMethods();
        //scanner for user input
        Scanner sc1 = new Scanner(System.in);
        //initial declaration to hold the users input as an int
        int userInput;

        //do while loop will prompt the user for an int input and then run the method desired
        do {
            System.out.println("1. View Contacts");
            System.out.println("2. Add a New Contact");
            System.out.println("3. Search a Contact By Name");
            System.out.println("4. Delete an Existing Contact");
            System.out.println("5. Exit");
            System.out.println("Enter an option 1, 2, 3, 4, 5");

            //assigning the value of the userInput to declared variable within scope
            userInput = sc1.nextInt();
                //conditionals take users input and run desired method and catch error if userInput is invalid
                if (userInput == 1) utilities.displayContacts();
                else if (userInput == 2) utilities.addContact();
                else if (userInput == 3) utilities.searchContact();
                else if (userInput == 4) utilities.deleteContact();
                else if (userInput == 5) System.out.println("Goodbye!");
                else System.out.println("Invalid Input");
            }

            //loop is exited if userInput equals 5
            while (userInput != 5) ;
    }
}
