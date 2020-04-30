package Course.IteratorAndIterable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class FilteredList<T> implements Predicate<T> {
    private List<T> list;
    private Predicate<T> pred;

    public FilteredList(List <T> list, Predicate <T> pred) {
        this.list = list;
        this.pred = pred;
    }
    public Iterator <T> iterator(){
        return new FilteredListIterator(list,pred);
    }

    @Override
    public boolean test(T x) {
        return false;
    }

    private class FilteredListIterator<T> implements Iterator <T> {
        private List<T> list;
        private Predicate<T> pred;
        private int index;
        public FilteredListIterator(List <T> list, Predicate <T> pred) {
            this.list = list;
            this.pred = pred;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            while(index<list.size()&&!pred.test(list.get(index))){
                index++;
            }
            return  (index<list.size());
        }
        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            index++;
            return list.get(index-1);
        }
    }

    public void FilteredListFilter(){

    }

    public static void main(String[] args) {
        List<Integer> one = new  LinkedList<>();
        one.add(1);
        List<String> str = new LinkedList <>();
        str.add("one");
//        Predicate<Integer> two = new Predicate <Integer>() {
//        };
//        two.add(2);
//        FilteredList<Integer> ex = new FilteredList <Integer>(one,two);

    }

}
