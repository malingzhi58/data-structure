//package Course2.ch04.exercises;
//
//import java.util.*;
//
//class UnderflowException extends Exception {
//};
//
//public class MyTreeSet2<AnyType extends Comparable <? super AnyType>> {
//    private static class BinaryNode<AnyType> {
//        BinaryNode(AnyType theElement)
//        {
//            this(theElement, null, null, null, null);
//        }
//
//        BinaryNode(AnyType theElement, BinaryNode <AnyType> lt, BinaryNode <AnyType> rt, BinaryNode <AnyType> nt, BinaryNode <AnyType> pv) {
//            element = theElement;
//            left = lt;
//            right = rt;
//            next = nt;
//            prev = pv;
//        }
//
//        AnyType element;
//        BinaryNode <AnyType> left;
//        BinaryNode <AnyType> right;
//        BinaryNode <AnyType> next;
//        BinaryNode <AnyType> prev;
//    }
//
//    public java.util.Iterator <AnyType> iterator() {
//        return new MyTreeSet2Iterator();
//    }
//
//    private class MyTreeSet2Iterator implements java.util.Iterator <AnyType> {
//        private BinaryNode <AnyType> current = findMin(root);
//        private BinaryNode <AnyType> previous;
//        private int expectedModCount = modCount;
//        private boolean okToRemove = false;
//        private boolean atEnd = false;
//
//        public boolean hasNext() {
//            return !atEnd;
//        }
//
//        public AnyType next() {
//            if (modCount != expectedModCount) throw new java.util.ConcurrentModificationException();
//            if (!hasNext()) throw new java.util.NoSuchElementException();
//            AnyType nextItem = current.element;
//            previous = current;
//            current = current.next;
//            if (current == null) atEnd = true;
//            okToRemove = true;
//            return nextItem;
//        }
//
//        Weiss Java
//        Solutions pages
//        p . 36(chap04)
//        Windfall Software, PCA
//        ZzTEX 12.2
//        Solutions37public
//
//        void remove() {
//            if (modCount != expectedModCount) throw new java.util.ConcurrentModificationException();
//            if (!okToRemove) throw new IllegalStateException();
//            MyTreeSet2.this.remove(previous.element);
//            okToRemove = false;
//        }
//    }
//
//    public MyTreeSet2() {
//        root = null;
//    }
//
//    public void makeEmpty() {
//        modCount++;
//        root = null;
//    }
//
//    public boolean isEmpty() {
//        return root == null;
//    }
//
//    public boolean contains(AnyType x) {
//        return contains(x, root);
//    }
//
//    public AnyType findMin() throws UnderflowException {
//        if (isEmpty()) throw new UnderflowException();
//        elsereturn findMin (root).element;
//    }
//
//    public AnyType findMax() throws UnderflowException {
//        if (isEmpty()) throw new UnderflowException();
//        elsereturn findMax (root).element;
//    }
//
//    public void insert(AnyType x) {
//        root = insert(x, root, null, null);
//    }
//
//    public void remove(AnyType x) {
//        root = remove(x, root);
//    }
//
//    Weiss Java
//    Solutions pages
//    p . 37(chap04)
//    Windfall Software, PCA
//    ZzTEX 12.2
//            38Chapter 4Treespublic
//
//    void printTree() {
//        if (isEmpty()) System.out.println("Empty tree");
//        elseprintTree(root);
//    }
//
//    private void printTree(BinaryNode <AnyType> t) {
//        if (t != null) {
//            printTree(t.left);
//            System.out.println(t.element);
//            printTree(t.right);
//        }
//    }
//
//    private boolean contains(AnyType x, BinaryNode <AnyType> t) {
//        if (t == null) return false;
//        int compareResult = x.compareTo(t.element);
//        if (compareResult < 0) return contains(x, t.left);
//        else if (compareResult > 0) return contains(x, t.right);
//        elsereturn
//        true; // match}private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t ){if(t==null )return null;else if ( t.left == null )return t;return findMin( t.left );}private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t ){if(t==null )return null;else if ( t.right == null )Weiss Java Solutions pages    p. 38 (chap04)Windfall Software, PCA  ZzTEX 12.2
//        Solutions39return t;
//        return findMax(t.right);
//    }
//
//    private BinaryNode <AnyType> insert(AnyType x, BinaryNode <AnyType> t, BinaryNode <AnyType> nt, BinaryNode <AnyType> pv) {
//        if (t == null) {
//            modCount++;
//            BinaryNode <AnyType> newNode = new BinaryNode <AnyType>(x, null, null, nt, pv);
//            if (nt != null) {
//                nt.prev = newNode;
//            }
//            if (pv != null) {
//                pv.next = newNode;
//            }
//            return newNode;
//        }
//        int compareResult = x.compareTo(t.element);
//        if (compareResult < 0) t.left = insert(x, t.left, t, pv);
//        else if (compareResult > 0) {
//            t.right = insert(x, t.right, nt, t);
//        } else
//            ; // duplicatereturn t;}private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t ){if(t==null )return t; // not foundint compareResult = x.compareTo( t.element );if ( compareResult < 0)t.left = remove( x, t.left );else if ( compareResult > 0)t.right = remove( x, t.right );else if ( t.left != null && t.right != null ) // two childrenWeiss Java Solutions pages    p. 39 (chap04)Windfall Software, PCA  ZzTEX 12.2
//        40 Chapter 4 Trees {
//            t.element = findMin(t.right).element;
//            t.right = remove(t.element, t.right);
//        }else{
//            modCount++;
//            t.prev.next = t.next;  // update next and prev linkst.next.prev = t.prev;t = ( t.left != null ) ? t.left : t.right;}return t;}private BinaryNode<AnyType> root;int modCount = 0;}