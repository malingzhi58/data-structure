package proj1b;
import proj1b.*;
/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        String filename = "word.txt";
        In in = new In(filename);
//        Palindrome palindrome = new Palindrome();
//        CharacterComparator cc = new OffByN(3);
        while (!in.isEmpty()) {
            String word = in.readString();
//            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
//                System.out.println(word);
//            }
            System.out.println(word);
        }
    }
}
