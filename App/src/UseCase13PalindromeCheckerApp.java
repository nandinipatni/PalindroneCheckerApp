import java.util.Scanner;
import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Palindrome Checker - UC13 Performance Comparison");
        System.out.print("Enter a string: ");

        String input = sc.nextLine();

        // ----- Algorithm 1: Two Pointer -----
        long start1 = System.nanoTime();

        boolean result1 = twoPointerPalindrome(input);

        long end1 = System.nanoTime();

        long time1 = end1 - start1;


        // ----- Algorithm 2: Stack -----
        long start2 = System.nanoTime();

        boolean result2 = stackPalindrome(input);

        long end2 = System.nanoTime();

        long time2 = end2 - start2;


        System.out.println("\nResults:");

        System.out.println("Two Pointer Result: " + result1);
        System.out.println("Execution Time: " + time1 + " ns");

        System.out.println();

        System.out.println("Stack Result: " + result2);
        System.out.println("Execution Time: " + time2 + " ns");

        sc.close();
    }


    // Two pointer algorithm
    public static boolean twoPointerPalindrome(String input) {

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


    // Stack algorithm
    public static boolean stackPalindrome(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {

            if (c != stack.pop()) {
                return false;
            }

        }

        return true;
    }
}