import java.util.Stack;
// "static void main" must be defined in a public class.
public class Main {
    
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int d){
            val = d;
            left = null;
            right = null;
        }
    }
    
    /*
        In order traversal 
        Recursive version.
    */
    private static void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    /*
        In order traversal 
        Iterative version.
    */
    private static void inOrderIterative(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.val+" ");
            
            if(node.right!=null){
                node = node.right;
                while(node!=null){
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }
    
    /* 
        Pre-Order Traversal
        Recursive
    */
    private static void preOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    /*
        preOrder traversal
        Iterative
    */
    private static void preOrderIterative(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.val+" ");
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
    }
    
    /*
        postOrder traversal
        Recursive
    */
    private static void postOrder(TreeNode root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    
    /*
        postOrder traversal
        Iterative
    */
    private static void postOrderIterative(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            
            if(node.left != null){
                stack1.push(node.left);
            }
            if(node.right != null){
                stack2.push(node.right);
            }
        }
        while(!stack2.isEmpty()){
            TreeNode node = stack2.pop();
            System.out.print(node.val+" ");
        }
    }
    
    /*
        Level Order Traversal
        Iterative
    */
    private static void levelOrderIterative(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val+" ");
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
    }
    
    /*
        Height of a binary tree
        Recursive
    */
    private static int heightTree(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(heightTree(root.left),heightTree(root.right));
    }
    
    /*
        Height of a binary tree
        Iterative
    */
    private static int heightTreeIterative(TreeNode root){
        if(root == null) return 0;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            level++;
        }
        return level;
    }
    
    /*
        Full Tree or Not?
        Iterative
    */
    private static boolean isFullTree(TreeNode root){
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right != null) return false;
                if(node.left != null && node.right == null) return false;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return true;
    }
    
    /*
        isSameTree or Not?
        Recursive
    */
    private static boolean isSameTree(TreeNode p,TreeNode q){
        if(p == null || q == null) return p == q;
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    
    /*
        Symmetric Tree or Not?
            - Mirror Image
    */
    private static boolean isTreeSymmetric(TreeNode root){
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }
    
    /*
        Children sum parent
        Iterative
    */
    private static int isSumProperty(TreeNode root)
    {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null) break;
                int sum = node.left != null ? node.left.val : 0;
                sum += node.right != null ? node.right.val : 0;
               // System.out.println(sum);
                if(sum != node.val) return 0;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return 1;
    }
    
    /*
        Level Order Traversal 
        Line By Line
    */
    private static void levelOrderIterativeLine(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                System.out.print(node.val+" ");
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            System.out.println();
        }
    }
    
    /*
        Maximum Width of binary tree
        Iterative
    */
    private static int maxTreeWidth(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int size = queue.size();
            max = Math.max(max,size);
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return max;
    }
    
    /*
        Balanced Binary Tree
        Recursive
    */
    private static boolean isTreeBalanced(TreeNode root){
        if(root == null) return true;
        int lHeight = heightTree(root.left);
        int rHeight = heightTree(root.right);
        if(Math.abs(lHeight - rHeight) > 1) return false;
        return isTreeBalanced(root.left) && isTreeBalanced(root.right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        //root.left.left = new TreeNode(3);
        //root.left.right = new TreeNode(4);
        TreeNode rootA = new TreeNode(1);
        rootA.left = new TreeNode(2);
        rootA.right = new TreeNode(5);
        rootA.left.left = new TreeNode(3);
        rootA.left.right = new TreeNode(4);
        boolean isBalanced = isTreeBalanced(root);
        System.out.println(isBalanced);
        //levelOrderIterativeLine(rootA);
        //int ans = isSumProperty(root);
        //boolean isSymmetric = isTreeSymmetric(root);
        //boolean ans = isSameTree(root,rootA);
        //System.out.println(ans);
        //boolean isFullTree = isFullTree(root);
        //System.out.println(isFullTree);
        //int heightOfTree = heightTree(root);
        //heightOfTree = heightTreeIterative(root);
        //System.out.println(heightOfTree);
        //levelOrderIterative(root);
        //postOrderIterative(root);
        //preOrderIterative(root);
        //inOrderIterative(root);
    }
}
