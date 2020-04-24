package Course2.ch03.exercises.e04;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Union<T> {
    public static <T> LinkedList<T> intersectionSet(LinkedList<T> one, LinkedList<T> two){
        LinkedList<T> interescted = new LinkedList <>();
        for(T tone:one){
            for(T ttwo:two){
                if (tone.equals(ttwo)){
                    interescted.add(tone);
                }
            }
        }
        return interescted;
    }
    public static <T extends Comparable<? super T>> LinkedList<T> UionSet(LinkedList<T> one, LinkedList<T> two){
        LinkedList<T> interescted = new LinkedList <>();
        Iterator<T> oneIterator = one.iterator();
        Iterator<T> twoIterator = two.iterator();
        T oneItem, twoItem;
        if(oneIterator.hasNext()&&twoIterator.hasNext()){
            oneItem =oneIterator.next();
            twoItem =twoIterator.next();
            while(oneItem!=null&&twoItem!=null){
//            if(oneItem.compa)
                int compareItem = oneItem.compareTo(twoItem);
                if(compareItem == 0){
                    interescted.add(oneItem);
                    oneItem = oneIterator.hasNext()? oneIterator.next():null ;
                }else if(compareItem < 0){
                    oneItem = oneIterator.hasNext()? oneIterator.next():null ;
                }
            }
        }

        return interescted;
    }

    public static void main(String[] args) {
        LinkedList <String> L1 = new LinkedList <>(Arrays.asList("a", "b", "c", "d", "e"));
        LinkedList <String> L2 = new LinkedList <>(Arrays.asList("a", "b"));
        LinkedList<String> ex= intersectionSet(L1,L2);
        Iterator<String> exIterator = ex.iterator();
        while(exIterator.hasNext()){
            System.out.println(exIterator.next());
        }
    }
}
