package Course.syntax3.accessControl.syntax3.map;


//import lab3.LinkedList.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

class KthLinkedList<Integer> implements Iterator<Integer> {
    public int k;
    public LinkedList<Integer> curList;
    public boolean hasNext;

    public KthLinkedList(int k, LinkedList curList) {
        this.k = k;
        this.curList = curList;
        this.hasNext = true;
    }
    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override
    public Integer next() {
        Integer toReturn = curList.getFirst();
        for(int i=0;i<k;i++){
//            curList = curList.;
        }
        hasNext = (curList!=null);
        return toReturn;
    }

    public static void main(String[] args) {
        LinkedList one = new LinkedList();
        
    }
}
