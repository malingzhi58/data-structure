package proj1b.proj1b;

import proj1b.ArrayDeque;
import proj1b.Deque;

public class Palindrome{
    public  Deque <Character> wordToDeque(String word) {
        Deque<Character> one = new ArrayDeque <>();
        for(int i =0;i<word.length();i++){
            one.addLast(word.charAt(i));
        }
        return one;
    }
    private  boolean isPalindrome(Deque<Character> wordInDeque) {
        return wordInDeque.removeFirst() ==wordInDeque.removeLast() && isPalindrome(wordInDeque);
    }
    public boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    public static void main(String[] args) {
        String ex = String.valueOf("toypqzzzqpyot");
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome("madam"));
//        System.out.println(ex);
//        Boolean bol= isPalindrome(ex);

    }
}
