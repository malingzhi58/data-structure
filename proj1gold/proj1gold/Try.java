package proj1gold.proj1gold;

import org.junit.Test;
import static org.junit.Assert.*;
import proj1gold.ArrayDequeSolution;
import proj1gold.StdRandom;
import proj1gold.StudentArrayDeque;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Try {
    @Test
    public void testArratDeque() {
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        // addLast
        for (int i=0; i<10; i++) {
            int random = StdRandom.uniform(100);
            ads.addLast(random);
            sad.addLast(random);
        }
        for (int i=0; i<10; i++) {
            int actual = ads.get(i);
            int expected = sad.get(i);
            assertEquals("Oh noooo!\nThis is bad in addLast():\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }
        int ac =2;
        int exp = 3;
        assertEquals("oon",ac,exp,ac);

//        // addFirst
//        for (int i=0; i<10; i++) {
//            int random = StdRandom.uniform(100);
//            ads.addFirst(random);
//            sad.addFirst(random);
//        }
//        for (int i=0; i<10; i++) {
//            int actual = ads.get(i);
//            int expected = sad.get(i);
//            assertEquals("Oh noooo!\nThis is bad in addFirst():\n   Random number " + actual
//                            + " not equal to " + expected + "!",
//                    expected, actual);
//        }
//
//        // removeFirst
//        List <Integer> actualList = new ArrayList <>();
//        List<Integer> expectedList = new ArrayList<>();
//        for (int i=0; i<10; i++) {
//            actualList.add(ads.removeFirst());
//            expectedList.add(sad.removeFirst());
//        }
//        for (int i=0; i<10; i++) {
//            int actual = ads.get(i);
//            int expected = sad.get(i);
//            assertEquals("Oh noooo!\nThis is bad in removeFirst():\n   Random number " + actual
//                            + " not equal to " + expected + "!",
//                    expected, actual);
//        }
//        for (int i=0; i<10; i++) {
//            int actual = actualList.get(i);
//            int expected = expectedList.get(i);
//            assertEquals("Oh noooo!\nThis is bad in removeFirst():\n   Random number " + actual
//                            + " not equal to " + expected + "!",
//                    expected, actual);
//        }
//
//
//        // removeLast
//        actualList.clear();
//        expectedList.clear();
//        for (int i=0; i<10; i++) {
//            actualList.add(ads.removeLast());
//            expectedList.add(sad.removeLast());
//        }
//        int actual = ads.size();
//        int expected = sad.size();
//        assertEquals("Oh noooo!\nThis is bad in removeLast():\n   actual size " + actual
//                        + " not equal to " + expected + "!",
//                expected, actual);
//        for (int i=0; i<10; i++) {
//            assertEquals("Oh noooo!\nThis is bad in removeLast():\n   Random number " + actualList.get(i)
//                            + " not equal to " +  expectedList.get(i) + "!",
//                    expectedList.get(i), actualList.get(i));
//        }
//
//    }
//
//
//    @Test
//    public void testArratDeque2() {
//        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
//        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
//        int random = StdRandom.uniform(100);
//        ads.addFirst(random);
//        sad.addFirst(random);
//        assertEquals("addFirst("+random+")", ads.get(0), sad.get(0));
//        System.out.println("addFirst("+random+")");
//
//        random = StdRandom.uniform(100);
//        ads.addLast(random);
//        sad.addLast(random);
//        assertEquals("addLast("+random+")", ads.get(1), sad.get(1));
//        System.out.println("addLast("+random+")");
//
//        int actual = ads.removeFirst();
//        int expected = ads.removeFirst();
//        assertEquals("removeFirst()", actual, expected);
//        System.out.println("removeFirst()");
//
//        actual = ads.removeLast();
//        expected = sad.removeLast();
//        assertEquals("removeLast()", actual, expected);
//        System.out.println("removeLast()");
    }

//    public static void main(String[] args) {
////        for (int i=0; i<10; i++) {
////            int random = StdRandom.uniform(100);
////            System.out.println(random);
////        }
//        proj1gold.ArrayDequeSolution <Integer> ads = new ArrayDequeSolution <>();
//        proj1gold.StudentArrayDeque <Integer> sad = new StudentArrayDeque <>();
//        // addLast
//        for (int i=0; i<10; i++) {
//            int random = StdRandom.uniform(100);
//            ads.addLast(random);
//            sad.addLast(random);
//        }
//        for (int i=0; i<10; i++) {
//            int actual = ads.get(i);
//            int expected = sad.get(i);
//            assertEquals("Oh noooo!\nThis is bad in addLast():\n   Random number " + actual
//                            + " not equal to " + expected + "!",
//                    expected, actual);
//        }
//    }
}
