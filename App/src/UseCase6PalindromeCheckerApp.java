import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class UseCase6PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";   // Change input if needed

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // 1. Enqueue characters & Push characters
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome = true;

        for (int i = 0; i < input.length(); i++) {
            char fromStack = stack.pop();       // LIFO
            char fromQueue = queue.remove();    // FIFO

            if (fromStack != fromQueue) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }
    }
}
