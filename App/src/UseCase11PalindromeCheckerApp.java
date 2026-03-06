import java.util.Scanner;

/*
 * UC11 – Object-Oriented Palindrome Service
 *
 * This program demonstrates palindrome validation using
 * object-oriented design.
 *
 * The palindrome logic is encapsulated inside the
 * PalindromeService class.
 */

public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Palindrome Checker - UC11");
        System.out.print("Enter a string: ");

        String input = sc.nextLine();

        // Create object of service class
        PalindromeService service = new PalindromeService();

        boolean result = service.checkPalindrome(input);

        if (result) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        sc.close();
    }
}


/*
 * Service class that contains palindrome logic
 */

class PalindromeService {

    public boolean checkPalindrome(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {

            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}