import java.util.Scanner;

public class ContactManagerMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int userInput;
        do {
            System.out.println("1. View Contacts");
            System.out.println("2. Add a New Contact");
            System.out.println("3. Search a Contact By Name");
            System.out.println("4. Delete an Existing Contact");
            System.out.println("Exit");
            System.out.println("Enter an option 1, 2, 3, 4, 5");

            userInput = sc.nextInt();
            if(userInput == 1)
                System.out.println(1);
            else if (userInput == 2)
                System.out.println(2);
            else if (userInput == 3)
            System.out.println(3);
            else if (userInput == 4)
                System.out.println(4);
            else
                System.out.println("Invalid Input");
        }
        while (userInput != 5);

    }
}
