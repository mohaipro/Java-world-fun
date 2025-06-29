import java.util.Scanner;

/**
 * School Quiz Checker
 * --------------------
 * This program collects scores for students in a class,
 * then allows the user to interactively get statistics 
 * about the scores, such as maximum, minimum, range, and average.
 * The program runs in a loop until the user chooses to exit.
 * 
 * Author: [Your Name]
 * Date: [Date]
 */

public class Main {
    public static void main(String[] args) {
        // Print a welcome message
        System.out.println("Hello and Welcome to School Quiz Checker!");

        // Create a Scanner object to read input from the user
        Scanner keyboard = new Scanner(System.in);

        // Prompt user to enter the number of students in the class
        System.out.print("Enter the number of class students: ");
        int x = keyboard.nextInt();
        System.out.printf("Number of students in the class >> %d\n", x);

        // Create an array to store the scores of each student
        int[] arr = new int[x];

        // Collect scores for each student using a loop
        for (int i = 0; i < x; i++) {
            System.out.printf("Student score ID(%d) >> ", i + 1);
            arr[i] = keyboard.nextInt();
        }

        // Consume leftover newline character
        keyboard.nextLine(); 

        // Infinite loop to allow multiple statistics operations
        while (true) {
            System.out.println("Thanks for entering the students class scores!");
            System.out.println("What statistics do you want to know about the class?");
            System.out.println("Max (mx) | Min (mn) | Range (rg) | Average (ag)");

            // Get the user’s choice of operation
            String option = keyboard.nextLine();
            System.out.println("Operation chosen is -> " + option);

            if (option.equals("mx")) {
                // Find the maximum score
                int max = arr[0];
                for (int j = 1; j < x; j++) {
                    if (arr[j] > max) {
                        max = arr[j];
                    }
                }
                System.out.println("Max score in class >> " + max);
            } else if (option.equals("mn")) {
                // Find the minimum score
                int min = arr[0];
                for (int j = 1; j < x; j++) {
                    if (arr[j] < min) {
                        min = arr[j];
                    }
                }
                System.out.println("Min score in class >> " + min);
            } else if (option.equals("rg")) {
                // Calculate the range (max - min)
                int max = arr[0];
                int min = arr[0];
                for (int j = 1; j < x; j++) {
                    if (arr[j] > max) {
                        max = arr[j];
                    }
                    if (arr[j] < min) {
                        min = arr[j];
                    }
                }
                int range = max - min;
                System.out.println("Range of scores in class >> " + range);
            } else if (option.equals("ag")) {
                // Calculate the average score
                double sum = 0.0;
                for (int j = 0; j < x; j++) {
                    sum += arr[j];
                }
                double average = sum / x;
                System.out.println("Average of scores in class >> " + average);
            } else {
                // Handle invalid option input
                System.out.println("No operation like that is allowed in the program!");
            }

            // Ask user if they want to exit or continue
            System.out.print("Do you want to exit or continue? (e | c): ");
            String next = keyboard.nextLine();
            char opt = next.charAt(0);

            if (opt == 'e') {
                // Exit the loop and program
                break;
            } else {
                System.out.println("Continuing...\n");
            }
        }

        // Goodbye message and close the Scanner
        System.out.println("Thanks for using the program. Bye!");
        keyboard.close();
    }
}
