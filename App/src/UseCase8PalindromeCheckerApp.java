class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class UseCase8PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "racecar";

        Node head = null;
        Node tail = null;

        // Convert string to linked list
        for (char c : word.toCharArray()) {
            Node newNode = new Node(c);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Find middle using fast and slow pointer
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Compare halves
        Node first = head;
        Node second = prev;

        boolean isPalindrome = true;

        while (second != null) {

            if (first.data != second.data) {
                isPalindrome = false;
                break;
            }

            first = first.next;
            second = second.next;
        }

        if (isPalindrome) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }

    }
}