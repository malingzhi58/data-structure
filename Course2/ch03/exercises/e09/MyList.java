//package Course2.ch03.exercises.e09;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Iterator;
//
//public class MyArrayList<AnyType> extends ArrayList {
//    /**
//     * Constructs an empty list with the specified initial capacity.
//     *
//     * @param initialCapacity the initial capacity of the list
//     * @throws IllegalArgumentException if the specified initial capacity
//     *                                  is negative
//     */
//    public MyArrayList(int initialCapacity) {
//        super(initialCapacity);
//    }
//
//    /**
//     * Constructs an empty list with an initial capacity of ten.
//     */
//    public MyArrayList() {
//    }
//
//    /**
//     * Constructs a list containing the elements of the specified
//     * collection, in the order they are returned by the collection's
//     * iterator.
//     *
//     * @param c the collection whose elements are to be placed into this list
//     * @throws NullPointerException if the specified collection is null
//     */
//    public MyArrayList(Collection c) {
//        super(c);
//    }
//
//    //    @Override
//    public void addAll(Iterable <? extends AnyType> items) {
//        Iterator <? extends AnyType> iter = items.iterator();
//        while (iter.hasNext()) {
//            add(iter.next());
//        }
//    }
//
//    public java.util.Iterator <AnyType> iterator() {
//        return new ArrayListIterator();
//    }
//
//    public java.util.ListIterator <AnyType> listIterator() {
//        return new ArrayListIterator();
//    }
//
//    private class ArrayListIterator implements java.util.ListIterator <AnyType> {
//        private int current = 0;
//        boolean backwards = false;
//
//        public boolean hasNext() {
//            return current < size();
//        }
//
//        public AnyType next() {
//            if (!hasNext()) throw new java.util.NoSuchElementException();
//            backwards = false;
//            return theItems[current++];
//        }
//
//
//        boolean hasPrevious() {
//            return current > 0;
//        }
//
//        public AnyType previous() {
//            if (!hasPrevious()) throw new java.util.NoSuchElementException();
//            backwards = true;
//            return theItems[--current];
//        }
//
//        public void add(AnyType x) {
//            MyArrayList.this.add(current++, x);
//        }
//
//        public void remove() {
//            if (backwards) MyArrayList.this.remove(current--);
//            elseMyArrayList.this.remove(--current);
//        }
//
//        public void set(AnyType newVal) {
//            MyArrayList.this.set(current, newVal);
//        }
//
//        public int nextIndex() {
//            throw new java.lang.UnsupportedOperationException();
//        }
//
//        public int previousIndex() {
//            throw new java.lang.UnsupportedOperationException();
//        }
//    }
//
//    public static void main(String[] args) {
//        MyArrayList <Integer> one = new MyArrayList <>();
//        MyArrayList <Integer> two = new MyArrayList <>();
//        ArrayList <? extends Integer> three = new ArrayList <>();
//        for (int i = 0; i < 10; i++) {
//            two.add(i);
//        }
//        Iterator <Integer> twoIterator = two.iterator();
//        one.add(1);
////        one.addAll(three);
//        Iterator <Integer> oneI = one.iterator();
//        while (oneI.hasNext()) {
//            System.out.println(oneI.next());
//        }
//
//    }
//}
