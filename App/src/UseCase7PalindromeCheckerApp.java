public class UseCase7PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";

        char[] arr = word.toCharArray();

        boolean isPalindrome = true;

        for (int i = 0; i < arr.length / 2; i++) {

            if (arr[i] != arr[arr.length - 1 - i]) {
                isPalindrome = false;
                break;
            }

        }

        if (isPalindrome) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }

    }
}