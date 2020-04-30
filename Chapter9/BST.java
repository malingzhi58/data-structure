package Chapter9;

enum Week{Monday,Tuesday, Wendsday,Thuesday
}
public class BST<Key> {
    private Key key;
    private BST left;
    private BST right;

    public BST(Key key, BST left, BST Right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public BST(Key key) {
        this.key = key;
    }

//    private  Enum{
////        for(Week week:Week ){
////
////        }
//    }
}
