package Course2.ch03;

public class MyArrayList4<AnyType>  {
    private static class Node<AnyType> {
        public AnyType data;
//        public Node <AnyType> prev;
        public Node <AnyType> next;

        public Node(AnyType val, Node <AnyType> nextNode) {
            data = val;
            next = nextNode;
        }
    }
    public Node<AnyType> my;
    public MyArrayList4(){
        my = new Node <>(null,null);
    }
    public void add(AnyType data){
        Node<AnyType> oen = new Node <>(data,my);
    }

}
