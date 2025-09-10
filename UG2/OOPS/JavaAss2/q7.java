import java.util.Scanner;

public class q7 {
    public int first(String in,char ch){
        int res=0;
        for(int i=0;i<in.length();i++)
            if(in.charAt(i)==ch)
            res++;

        return res;
    }
    public int second(String s,String t){
        int res=0;
        for(int i=0;i<s.length();i++)
            if(s.substring(i).startsWith(t))
            res++;

        return res;
    }
    public boolean third(String s,String t){
        return s.startsWith(t);
    }
    public char[] fourth(String s){
        return s.toCharArray();
    }
    public void fifth(String s,char t){
        for(String s1:s.split("%d",t)){
            System.out.println(s1);
        }
    }
    public String sixth(String word) {
        if (word == null || word.length() < 2) {
            return word;
        }

        String longest = "";
        for (int i = 0; i < word.length(); i++) {
            String oddPalindrome = expandAroundCenter(word, i, i);
            String evenPalindrome = expandAroundCenter(word, i, i + 1);

            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }
        return longest;
    }

    private static String expandAroundCenter(String word, int left, int right) {
        while (left >= 0 && right < word.length() && word.charAt(left) == word.charAt(right)) {
            left--;
            right++;
        }
        return word.substring(left + 1, right);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        q7 operations = new q7(); // Create an instance of the q7 class
        int choice;
        String input, target;
        char character;

        do {
            // Display the menu
            System.out.println("\n--- Menu ---");
            System.out.println("1. Count occurrences of a character in a string");
            System.out.println("2. Count occurrences of a substring in a string");
            System.out.println("3. Check if a string starts with a substring");
            System.out.println("4. Convert a string to a character array");
            System.out.println("5. Split a string by a character");
            System.out.println("6. Find the longest palindrome in a string");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    System.out.print("Enter a character to count: ");
                    character = scanner.nextLine().charAt(0);
                    int count = operations.first(input, character);
                    System.out.println("The character '" + character + "' occurs " + count + " times.");
                    break;

                case 2:
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    System.out.print("Enter a substring to count: ");
                    target = scanner.nextLine();
                    int subCount = operations.second(input, target);
                    System.out.println("The substring \"" + target + "\" occurs " + subCount + " times.");
                    break;

                case 3:
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    System.out.print("Enter a substring to check: ");
                    target = scanner.nextLine();
                    boolean startsWith = operations.third(input, target);
                    System.out.println("The string " + (startsWith ? "starts" : "does not start") + " with \"" + target + "\".");
                    break;

                case 4:
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    char[] charArray = operations.fourth(input);
                    System.out.println("Character array: ");
                    for (char c : charArray) {
                        System.out.print(c + " ");
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    System.out.print("Enter a character to split by: ");
                    character = scanner.nextLine().charAt(0);
                    System.out.println("Splitting the string by '" + character + "':");
                    operations.fifth(input, character);
                    break;

                case 6:
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    String longestPalindrome = operations.sixth(input);
                    System.out.println("The longest palindrome in the string is: \"" + longestPalindrome + "\"");
                    break;

                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
