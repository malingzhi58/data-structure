public class SLList2 {
    // this is my practice
    public class IntNode2 {
        public int item;
        public IntNode2 next;

        public IntNode2(int item, IntNode2 next) {
            this.item = item;
            this.next = next;
        }
    }

    //antoehr thing
    // add somthing new
    public IntNode2 first;

    public SLList2(int x) {
        first = null;
        first = new IntNode2(x, null);
    }
    public void addfirst2(int y){
        first = new IntNode2(y,first);
    }
    public int getfirst2() {
        return first.item;
    }
    public int size_way1(IntNode2 first){
        int size = 1;
        if(first == null){
            return size;
        }else {
            while (first != null) {
                first = first.next;
                size += 1;
            }
            return size;
        }
    }
    public int size(){
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
    private static int size(IntNode2 p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }
    public static void main(String[] args) {
        SLList2 L = new SLList2(1);
        L.addfirst2(2);
        L.addfirst2(3);
        int x = L.getfirst2();
        int y = L.size();
        System.out.println(y);
    }
}
