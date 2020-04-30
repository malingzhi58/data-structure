package Course.inheritance;/* Represent a list of stuff, where all the "list" work is delegated
 * to a naked recursive data structure. */

public class SLList<Blorp> implements List61B<Blorp>{
    public class Node {
        public Blorp item;     /* Equivalent of first */
        public Node next; /* Equivalent of rest */
        public Node(Blorp i, Node h) {
            item = i;
            next = h;
        }
    }

    private Node sentinel;
    private int size;

    /** Creates an empty list. */
    public SLList() {
        size = 0;
        sentinel = new Node(null, null);
    }

    public SLList(Blorp x) {
        size = 1;
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
    }

    /** Adds an item of the front. */
    public void addFirst(Blorp x) {
        Node oldFrontNode = sentinel.next;
        Node newNode = new Node(x, oldFrontNode);
        sentinel.next = newNode;
        size += 1;
    }
    public void add(Blorp x){
        Node newNode = new Node(x,sentinel.next);
        size ++;
        sentinel.next = newNode;

    }

    /** Gets the front item of the list. */
    public Blorp getFirst() {
        return sentinel.next.item;
    }

    /** Puts an item at the back of the list. */
    public void addLast(Blorp x) {
        size += 1;
        Node p = sentinel;
		/* Move p until it reaches the end. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(x, null);
    }
    public void addlast(Blorp x){
        Node p = sentinel;
        while(p.next !=null){
            p = p.next;
        }
        p.next = new Node(x,null);
        size ++;
    }

    /** Returns the back node of our list. */
    private Node getLastNode() {
        Node p = sentinel;
		/* Move p until it reaches the end. */
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }
    public Node getLastN(){
        Node p =sentinel;
        while(p.next != null){
            p = p.next;
        }
        return p;
    }

    /** Returns last item */
    public Blorp getLast() {
        Node back = getLastNode();
        return back.item;
    }

    /** Deletes and returns last item. */
    public Blorp removeLast() {
        Node back = getLastNode();
        if (back == sentinel) {
            return null;
        }
        size = size - 1;
        Node p = sentinel;
        while (p.next != back) {
            p = p.next;
        }
        p.next = null;
        return back.item;
    }

    public int size() {
        return size;
    }

    /** Gets the positionth item of the list. */
    public Blorp get(int position) {
        if (position == 0) {
            return getFirst();
        }
        Node currentNode = sentinel.next.next;
        while (position > 1 && currentNode.next != null) {
            position -= 1;
            currentNode = currentNode.next;
        }

        return currentNode.item;
    }

    /** Inserts item into given position.
     * Code from discussion #3 */
    public void insert(Blorp item, int position) {
        if (sentinel.next == null || position == 0) {
            addFirst(item);
            return;
        }
        if(position ==1 && sentinel.next.next ==null){
            addLast(item);
        }
        Node currentNode = sentinel.next.next;
        while (position > 1 && currentNode.next != null) {
            position -= 1;
            currentNode = currentNode.next;
        }

        Node newNode = new Node(item, currentNode.next);
        currentNode.next = newNode;
    }
    public void insert2(Blorp x, int pos){
        size ++;
        if(pos == 0||sentinel.next==null){
            addFirst(x);
            return;
        }else if(pos>0){
            Node cur = sentinel.next;
            while (pos>1 && cur.next !=null){

            }

            Node newN = new Node(x,cur.next);
            cur.next = newN;
        }

    }
    public void rotate(){
        Blorp back = removeLast();
        Node p = sentinel;
        addFirst(back);
    }
    public Node index(int x) throws Exception {
        if(x<-1 || x> size){
            throw new Exception("wrong para");
        }
        if(x ==-1){
            return sentinel;
        }
        int j = 0;
        Node p = sentinel;
        while (j<x){
            j++;
            p = p.next;
        }
        return p;
    }
    public void indexinsert(Blorp x,int pos) throws Exception {
        Node pre = index(pos-1);
        pre.next =new Node(x,pre.next);
    }


    /** TODO: Add a print method that overrides List61B's inefficient print method. */
    public static void main(String[] args) throws Exception {
        SLList<Integer> list = new SLList<>(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        SLList<Integer>.Node c = list.index(1);
        list.indexinsert(5,3);

//        Node list = new Node(4,list);
//        Node oldFrontNode = list.next;
//        Node newNode = new Node(x, oldFrontNode);
        for(SLList<Integer>.Node l = list.sentinel;l.next !=null;l = l.next ){
            System.out.println(l.item);
        }
//        int c = list.get(0);
//        System.out.println(c);


    }

} 