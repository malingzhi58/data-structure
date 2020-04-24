package Course2.ch03;


import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by cookfront on 2017/2/20.
 */
public class MyArrayList3<AnyType> implements Iterable<AnyType> {
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private AnyType[] theItems;

    public MyArrayList3() {
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
        theItems = (AnyType []) new Object[newCapacity];
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

    public Iterator<AnyType> iterator() {
        return new ArrayListIterator(this);
    }

    private static class ArrayListIterator<AnyType> implements Iterator<AnyType> {
        private int current = 0;
        private MyArrayList3<AnyType> theList;

        public ArrayListIterator( MyArrayList3 <AnyType> theList) {
            this.theList = theList;
        }

        public boolean hasNext() {
            return current < theList.size();
        }

        public AnyType next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theList.theItems[current++];
        }

//        public void remove() {
//            MyArrayList3.this.remove(--current);
//        }
    }

    public static void main(String[] args) {
        MyArrayList3<Integer> one = new MyArrayList3 <>();
        one.add(2);
        one.add(3);
        one.add(4);
        for(Integer ex: one){
            System.out.println(ex);
        }
    }
}

