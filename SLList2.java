public class SLList2<String2> {
    /*
     * IntNode
     * initialize SLList
     * method:addFirst,getFirst, addLast, size()
     */
    public class IntNode2 {
        public String2 item;
        public IntNode2 next;

        public IntNode2(String2 item, IntNode2 next) {
            this.item = item;
            this.next = next;
        }
    }

    public IntNode2 first;
    private int size;

    public SLList2(String2 x) {
        first = null;
        first = new IntNode2(x, null);
        size =1;
    }

    public void addfirst2(String2 y) {
        first = new IntNode2(y, first);
        size +=1;
    }

    public String2 getfirst2() {
        return first.item;
    }

    public int size_way1(IntNode2 first) {
        int size = 1;
        if (first != null) {
            while (first != null) {
                first = first.next;
                size += 1;
            }
        }
//        if (first == null) {
//            return size;
//        } else {
//            while (first != null) {
//                first = first.next;
//                size += 1;
//            }
        return size;
    }

    public int size() {
        return size(first);
    }

    /*
    public void addLast(int x) {
        IntNode p = first;


        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }*/
    private int size(IntNode2 p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }

    public static void main(String[] args) {
        SLList2<Integer> L = new SLList2<Integer>(1);
        L.addfirst2(2);
        L.addfirst2(3);
        int x = L.getfirst2();
        int y = L.size();
        System.out.println(y);
        System.out.println();
    }
}
