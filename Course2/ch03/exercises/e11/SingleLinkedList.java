package Course2.ch03.exercises.e11;

/**
 * Created by cookfront on 2017/5/10.
 */
public class SingleLinkedList<AnyType> {
    private static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> next;

        public Node() {
            this(null, null);
        }

        public Node(AnyType data) {
            this(data, null);
        }

        public Node(AnyType data, Node<AnyType> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<AnyType> head;
    private int theSize;

    public SingleLinkedList() {
        theSize = 0;
        head = new Node<AnyType>();
        head.next = null;
    }

    public boolean contains(AnyType x) {
        Node<AnyType> p = head.next;
        while (p != null) {
            if (x.equals(p.data)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public void print() {
        Node<AnyType> p = head.next;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public int size() {
        return theSize;
    }

    public boolean add(AnyType x) {
        if (contains(x)) {
            return false;
        }

        Node<AnyType> p = new Node<>(x, head.next);
        head.next = p;
        theSize++;

        return true;
    }

    public boolean remove(AnyType x) {
        if (!contains(x)) {
            return false;
        }

        Node<AnyType> prev = head;
        Node<AnyType> p = head.next;

        while (!p.data.equals(x)) {
            prev = p;
            p = p.next;
        }
        prev.next = p.next;
        theSize--;

        return true;
    }

    public static void main(String ...args) {
        SingleLinkedList<Integer> testList = new SingleLinkedList<>();

        System.out.println("list size: " + testList.size());

        testList.add(1);
        testList.add(2);
        testList.add(3);

        testList.print();

        if (testList.contains(3)) {
            System.out.println("test list have 3!");
        }

        testList.remove(2);

        testList.print();
    }
}
