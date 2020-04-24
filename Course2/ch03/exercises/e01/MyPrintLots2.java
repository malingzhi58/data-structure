package Course2.ch03.exercises.e01;

import java.util.*;

public class MyPrintLots2<AnyType> {
    public static <AnyType> void printLot(LinkedList<AnyType> L,LinkedList<Integer> P){
        Iterator<AnyType> Literator = L.iterator();
        Iterator<Integer> Piterator =P.iterator();
        int count =0;
        AnyType Lprint = null;
        while(Piterator.hasNext()&&Literator.hasNext()){
            Integer point = Piterator.next();
            System.out.println("Looking for position " + point);
            while(count<point){
                Lprint= Literator.next();
                count++;
            }
            System.out.println(Lprint);
        }
    }
    public static void main(String ...args) {
        LinkedList <String> L = new LinkedList <>(Arrays.asList("a", "b", "c", "d", "e"));
        LinkedList<Integer> P = new LinkedList <>(Arrays.asList(1, 3));

        printLot(L, P);
    }
}
