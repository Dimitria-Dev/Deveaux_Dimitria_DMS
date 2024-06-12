import java.util.InputMismatchException;
import java.util.Scanner;

/* Dimitria Deveaux
 * CEN 3024 - Software Development I
 * June 12th, 2024
 * MainApp.java
 *  The objective of this program is to allow an adoption agency worker track the adoption status and information of a child.
 *  A user will be able to check the current list of children in the system, check the adoption status of a child, update the
 *  interest or allergies of a child and update a child's adoption status.
 */

public class MainApp {
    public static void main(String[] args) {
        Child child = new Child();
        int userChoice;
        System.out.println("Welcome to the Adoption Agency Database");

        try {
            do {
                Scanner scanner = new Scanner(System.in);
                userChoice = displayMenu(scanner);
                switch (userChoice) {
                    case 1:
                        System.out.println("Enter the the file path you would like to read. \n For Windows enter the full C:file path. For Mac enter /Users/username/Desktop/filepath");
                        String filename = scanner.next();
                        child.fileName(filename);
                        child.printChildren();
                        break;

                    case 2:
                        System.out.println("1. To remove a child by their ID number | 2. To remove a child by their name");
                        try {
                            int removeChildOption = scanner.nextInt();
                            if (removeChildOption == 1) {
                                System.out.println("Enter the child ID you would like to remove");
                                int childID = scanner.nextInt();
                                child.removeByID(childID);
                                System.out.println("Child removed");
                                child.printChildren();

                            } else if (removeChildOption == 2) {
                                System.out.println("Enter the child name you would like to remove");
                                scanner.nextLine();

                                String childName = scanner.nextLine();
                                child.removeByName(childName);
                                System.out.println("Child removed");
                                child.printChildren();
                            } else {
                                System.out.println("Unable to remove the child. Please try again.");
                            }

                        }catch (InputMismatchException e){
                            System.out.println("There was an error removing the child. Please try again.");
                        }
                        break;
                    case 3:
                        System.out.println("1. Add an Interests | 2. Add an allergy. ");
                        int addInterestOption = scanner.nextInt();
                        if (addInterestOption == 1) {
                            System.out.println("Enter the child ID you like to update the interests for: ");
                            int childIDForInterest = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Enter the interest you like to add. Use a comma to separate the interests if there is more than one. ");
                            String interests = scanner.nextLine();

                            child.addInterest(childIDForInterest, interests);
                            System.out.println("Interest added.");
                            child.printChildren();

                        } else if (addInterestOption == 2) {
                            System.out.println("Enter the child ID you would like to add an allergy to: ");
                            int childIDForAllergy = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Enter the allergies you would like to add");
                            String allergies = scanner.nextLine();
                            child.addAllergy(childIDForAllergy, allergies);
                            System.out.println("Allergy added");
                            child.printChildren();

                        }
                        break;
                    case 4:
                        System.out.println("1. Check a child's adoption status | 2. Update a child's adoption status");
                        int statusOption = scanner.nextInt();

                        if(statusOption == 1){
                            System.out.println("Enter the child ID number you would like to check: ");
                            int childID = scanner.nextInt();
                            child.status(childID);


                        } else if (statusOption == 2) {
                            System.out.println("Enter the child ID you would like to update the Adoption Status for: ");
                            int childIDForAdoptionStatus = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Enter the Adoption Status you would like to update. \n Available For Adoption " +
                                    "| Processing Adoption | Adoption Finalized | Other");
                            String adoptionStatusOption = scanner.nextLine();

                            child.adoptionStatus(childIDForAdoptionStatus, adoptionStatusOption);
                            System.out.println("Adoption Status updated.");
                            child.printChildren();
                        }
                        break;
                    case 5:
                        child.printChildren();
                        break;
                    case 6:
                        System.out.println("");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } while (userChoice != 7);
        } catch (InputMismatchException e){
            System.out.println("Please select a valid option from the menu. Try again. ");
        }
    }

    /* method: displayMenu
     * parameter: Scanner input
     * return: input
     * purpose: to display a menu for user to choose from
     * */
    public static int displayMenu(Scanner input) {
        System.out.println("  Choose From the Following Options  ");
        System.out.println(" | 1. Upload a file                | ");
        System.out.println(" | 2. Remove a child               | ");
        System.out.println(" | 3. Update a child's information | ");
        System.out.println(" | 4. Adoption Status              | ");
        System.out.println(" | 5. Show List of Children        | ");
        System.out.println(" | 6. Exit                         | ");
        return input.nextInt();
    }
}
