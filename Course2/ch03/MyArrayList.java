package Course2.ch03;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by cookfront on 2017/2/20.
 */
public class MyArrayList<AnyType> implements Iterable <AnyType> {
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private AnyType[] theItems;

    public MyArrayList() {
        doClear();
    }

    public void clean() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public AnyType get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[index];
    }

    public AnyType set(int index, AnyType newVal) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType old = theItems[index];
        theItems[index] = newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }

        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public boolean add(AnyType val) {
        add(size(), val);
        return true;
    }

    public void add(int index, AnyType val) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > index; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[index] = val;
        theSize++;
    }

    public AnyType remove(int index) {
        AnyType removedItem = theItems[index];
        for (int i = index; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        return removedItem;
    }

    //    public Iterator<AnyType> iterator() {
//        return new ArrayListIterator();
//    }
////不知道这里为什么不用泛型
//    private  class ArrayListIterator implements Iterator<AnyType> {
//        private int current = 0;
//
//        public boolean hasNext() {
//            return current < size();
//        }
//
//        public AnyType next() {
//            if (!hasNext()) {
//                throw new NoSuchElementException();
//            }
//            return theItems[current++];
//        }
//
//        public void remove() {
//            MyArrayList.this.remove(--current);
//        }
//    }
    public java.util.Iterator <AnyType> iterator() {
        return new ArrayListIterator();
    }

    public java.util.ListIterator <AnyType> listIterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements ListIterator <AnyType> {
        private int current = 0;
        boolean backwards = false;

        public boolean hasNext() {
            return current < size();
        }

        public AnyType next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            backwards = false;
            return theItems[current++];
        }

        public boolean hasPrevious() {
            return current > 0;
        }

        public AnyType previous() {
            if (!hasPrevious()) throw new java.util.NoSuchElementException();
            backwards = true;
            return theItems[--current];
        }

        public void add(AnyType x) {
            MyArrayList.this.add(current++, x);
        }

        public void remove() {
            if (backwards) MyArrayList.this.remove(current--);
            else MyArrayList.this.remove(--current);
        }

        public void set(AnyType newVal) {
            MyArrayList.this.set(current, newVal);
        }

        public int nextIndex() {
            throw new java.lang.UnsupportedOperationException();
        }

        public int previousIndex() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        MyArrayList <Integer> one = new MyArrayList <>();
        one.add(2);
        one.add(3);
        one.add(4);
        for (Integer ex : one) {
            System.out.println(ex);
        }
    }
}
