package proj1b.proj1b; /** This class outputs all palindromes in the words file in the current directory. */
import proj1b.proj1b.In;
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        String inputFilename = "word.txt";
        Palindrome palindrome = new Palindrome();
        In in = new In(inputFilename);
////        Palindrome palindrome = new Palindrome();
//        String word = in.readString();
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word.strip())) {
                System.out.println(word);
            }
        }
    }
}
//Uncomment this class once you've written isPalindrome.