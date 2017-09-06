

/**
 * Created by aligizakis on 31/8/2017.
 */
public class Node {

    int data;
    Node left;
    Node right;

    static boolean  checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    static boolean  checkBST(Node node, int min, int max) {
        if (node == null) return true;
        return  min < node.data && node.data < max &&
                checkBST(node.left, min, node.data) &&
                checkBST(node.right, node.data, max);
    }

    public static void main(String []args){
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int a0 = 0; a0 < t; a0++) {
//            String expression = in.next();
//            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
//        }

        Node root = new Node();
        root.data=2;

        Node left = new Node();
        Node right = new Node();
        left.data=1;
        right.data=3;
        root.left=left;
        root.right=right;

        System.out.println( checkBST(root));

    }
}


