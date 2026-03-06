import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

/*
 * UC12 – Strategy Pattern for Palindrome Algorithms
 */

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Palindrome Checker - UC12");
        System.out.print("Enter a string: ");

        String input = sc.nextLine();

        System.out.println("Choose algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        boolean result = strategy.check(input);

        if (result) {
            System.out.println("Is Palindrome: true");
        } else {
            System.out.println("Is Palindrome: false");
        }

        sc.close();
    }
}


/*
 * STRATEGY INTERFACE
 */

interface PalindromeStrategy {

    boolean check(String input);

}


/*
 * STACK STRATEGY
 */

class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

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


/*
 * DEQUE STRATEGY
 */

class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {

            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }

        }

        return true;
    }
}