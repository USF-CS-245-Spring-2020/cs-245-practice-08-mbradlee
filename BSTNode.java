public class BSTNode <T extends Comparable>{

    T data;
    BSTNode left;
    BSTNode right;

    BSTNode(){
        this.data = null;
        this.left = null;
        this.right = null;
    }

    BSTNode(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }


}
