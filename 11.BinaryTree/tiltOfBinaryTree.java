

   // LEETCODE 

class tiltOfBinaryTree {
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

    
    public int ans;
    public int findTilt(TreeNode root) {
        
        travel(root);
        return ans;
    }
    
    public int travel(TreeNode root){
        if(root == null) return 0;
        
        int left = travel(root.left );
        int right = travel(root.right );
        
        ans += Math.abs(left-right);
        return left + right + root.val;
    }
}

