import java.util.Scanner;

// Week 2 Lab, 4 part lab.

public class StringLab {
    public static void main(String[] args) {
        // Task 1: Working with String Methods
        String str = " Welcome to the Java String Lab! ";
        System.out.println("Original String: \"" + str + "\"");

        // length()
        System.out.println("Length: " + str.length());

        // charAt()
        System.out.println("Character at index 7: " + str.charAt(7));

        // substring()
        System.out.println("Substring 'Java': " + str.substring(str.indexOf("Java"), str.indexOf("Java") + 4));

        // toUpperCase() and toLowerCase()
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());

        // indexOf()
        System.out.println("Index of 'Java': " + str.indexOf("Java"));

        // contains()
        System.out.println("Contains 'Lab': " + str.contains("Lab"));

        // replace()
        System.out.println("Replace 'Java' with 'Java Programming': " + str.replace("Java", "Java Programming"));

        // split()
        System.out.println("Split by spaces:");
        String[] words = str.split(" ");
        for (String word : words) {
            if (!word.isEmpty()) {
                System.out.println(word);
            }
        }

        // trim()
        System.out.println("Trimmed string: \"" + str.trim() + "\"");

        // equals() and equalsIgnoreCase()
        String compareStr = "java string lab!";
        System.out.println("Equals: " + str.trim().equals(compareStr));
        System.out.println("Equals Ignore Case: " + str.trim().equalsIgnoreCase(compareStr));

        // Task 2: Loop Challenges with Strings
        // Counting how many vowels from the original string, print the result.

        // For loop: Count vowels
        int vowelCount = 0;
        String lowerStr = str.toLowerCase();
        for (int i = 0; i < lowerStr.length(); i++) {
            char ch = lowerStr.charAt(i);
            if ("aeiou".indexOf(ch) != -1) {
                vowelCount++;
            }
        }
        System.out.println("Vowel Count: " + vowelCount);

        // While loop: Check for palindrome
        String word = "racecar";
        int left = 0, right = word.length() - 1;
        boolean isPalindrome = true;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println("Is '" + word + "' a palindrome? " + isPalindrome);

        // Do...while loop: Input validation
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print("Enter a sentence that contains the word 'Java': ");
            input = scanner.nextLine();
        } while (!input.contains("Java"));
        System.out.println("Thank you!");

        // Task 3: StringBuilder
        StringBuilder sb = new StringBuilder("StringBuilder Lab");
        sb.append(" - Learning Java");
        sb.insert(sb.indexOf("Lab") + 3, " is fun");
        sb.delete(sb.indexOf("Learning"), sb.indexOf("Learning") + "Learning".length());
        System.out.println("Reversed StringBuilder: " + sb.reverse());

        // Task 4: StringBuffer
        StringBuffer sbf = new StringBuffer("Multithreading Lab");
        sbf.append(" - Learning Java");
        sbf.insert(sbf.indexOf("Lab") + 3, " is fun");
        sbf.delete(sbf.indexOf("Learning"), sbf.indexOf("Learning") + "Learning".length());
        System.out.println("Reversed StringBuffer: " + sbf.reverse());

        scanner.close(); // Clean up scanner, end scanner
    }
}