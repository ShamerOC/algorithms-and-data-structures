package Trees;

public class Main {
    public static void main (String[] args) {
        BstTree bst = new BstTree(30);
        bst.add(20);
        bst.add(10);
        bst.add(25);
        bst.add(50);
        bst.add(60);
        bst.add(35);
//        bst.delete(30);

//        System.out.print(bst.check());
        int[] arr = bst.predecessorSuccessor(10);
        System.out.print(arr[0] + " " + arr[1]);
//        bst.preorder();
//        bst.inorder();
//        bst.postorder();
    }
}
