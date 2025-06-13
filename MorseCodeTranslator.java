import java.util.HashMap;
import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        HashMap<Character, String> morseMap = new HashMap<>();

        // Morse code map (letters, digits, some punctuation)
        morseMap.put('a', ".-");    morseMap.put('b', "-...");
        morseMap.put('c', "-.-.");  morseMap.put('d', "-..");
        morseMap.put('e', ".");     morseMap.put('f', "..-.");
        morseMap.put('g', "--.");   morseMap.put('h', "....");
        morseMap.put('i', "..");    morseMap.put('j', ".---");
        morseMap.put('k', "-.-");   morseMap.put('l', ".-..");
        morseMap.put('m', "--");    morseMap.put('n', "-.");
        morseMap.put('o', "---");   morseMap.put('p', ".--.");
        morseMap.put('q', "--.-");  morseMap.put('r', ".-.");
        morseMap.put('s', "...");   morseMap.put('t', "-");
        morseMap.put('u', "..-");   morseMap.put('v', "...-");
        morseMap.put('w', ".--");   morseMap.put('x', "-..-");
        morseMap.put('y', "-.--");  morseMap.put('z', "--..");

        morseMap.put('0', "-----"); morseMap.put('1', ".----");
        morseMap.put('2', "..---"); morseMap.put('3', "...--");
        morseMap.put('4', "....-"); morseMap.put('5', ".....");
        morseMap.put('6', "-...."); morseMap.put('7', "--...");
        morseMap.put('8', "---.."); morseMap.put('9', "----.");

        morseMap.put('.', ".-.-.-"); morseMap.put(',', "--..--");
        morseMap.put('?', "..--.."); morseMap.put('!', "-.-.--");
        morseMap.put(' ', "/");
        // Word separator

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message to convert to Morse code:");
        String input = scanner.nextLine().toLowerCase();

        StringBuilder morseOutput = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (morseMap.containsKey(ch)) {
                morseOutput.append(morseMap.get(ch)).append(" ");
            } else {
                morseOutput.append("? "); // unknown character
            }
        }

        System.out.println("\nMorse Code:");
        System.out.println(morseOutput.toString().trim());

        scanner.close();
    }
}
