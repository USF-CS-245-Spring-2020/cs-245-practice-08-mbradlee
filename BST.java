public class BST <T extends Comparable> extends BSTNode {

    BSTNode root = null;

    public boolean find(Comparable item){
        return find(root, item);
    }

    protected boolean find(BSTNode node, Comparable item){
        if(node == null)
            return false;
        if(node.data.compareTo(item) == 0){
            return true;
        }else if(node.data.compareTo(item) > 0){
            return find(node.left, item);
        }else{
            return find(node.right, item);
        }
    }

    public void insert(Comparable item){
        root = insert(root, item);
    }

    protected BSTNode insert(BSTNode node, Comparable item){
        if(node == null){
            BSTNode curr = new BSTNode(item);
            return curr;
        }
        if(node.data.compareTo(item) > 0){
            node.left = insert(node.left, item);
        }else if(node.data.compareTo(item) < 0){
            node.right = insert(node.right, item);
        }else{
            //duplicate
            return node;
        }

        return node;
    }

    public void delete(Comparable item){
        root = delete(root, item);
    }

    protected BSTNode delete(BSTNode node, Comparable item){
        if(node == null){
            return null;
        }

        if(node.data.compareTo(item) > 0){
            node.left = delete(node.left, item);
            return node;
        }else if(node.data.compareTo(item) < 0){
            node.right = delete(node.right, item);
            return node;
        }else{
            if(node.left == null){
                node.data = node.right.data;
                node.right = node.right.right;
            }else{
                node.data = removeSmallest(node);
            }
            return node;
        }
    }

    protected Comparable removeSmallest(BSTNode node){
        if(node.left.left == null){
            Comparable smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        }else{
            return removeSmallest(node.left);
        }
    }

    public void print(){
        print(root);
    }

    protected void print(BSTNode node){
        if(node != null){
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }

}
