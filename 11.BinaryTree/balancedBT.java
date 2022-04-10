
        //LEETCODE - 110

class balancedBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int height(TreeNode root){
        return root == null ? -1 : Math.max(height(root.left) , height(root.right)) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int leftH = height(root.left);
        int rightH = height(root.right);
        
        if(Math.abs(leftH - rightH) > 1) return false;
        
        boolean leftB = isBalanced(root.left);
        boolean rightB = isBalanced(root.right);
        
        return leftB && rightB;
    }
}


