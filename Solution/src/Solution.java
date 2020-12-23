import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.empty()){
            return stack2.pop();
        }
        int num;
        else {
            int i=stack1.size();
            for (int j = 0; j <i-1; j++) {
                num=stack1.pop();
                stack2.push(num);
            }
        }
        return stack1.pop();
    }

    public String solve (String s, String t) {
        // write code here
        
    }

    public static TreeNode createBinTree(String[] array, int num) {
        if (array[num] == "#") {
            return null;
        }
        TreeNode root = new TreeNode((Integer.parseInt(array[num])));
        if (num * 2 + 1 < array.length) {
            root.left = createBinTree(array, num * 2 + 1);
        }

        if (num * 2 + 2 < array.length) {
            root.right = createBinTree(array, num * 2 + 2);
        }
        return root;
    }

    String Serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }

        }
    }

    TreeNode Deserialize(String str) {

    }

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        Integer n = matrix.length - 1;
        Integer m = matrix[0].length - 1;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (matrix == null) {
            return null;
        }
        if (n == 0) {
            List list = new ArrayList<>(Arrays.asList(matrix[0]));
            return (ArrayList) list;
        }

    }



    public static void main(String[] args) {

    }
}
