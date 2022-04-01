/*

   LEETCODE 

class Solution {
    
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

*/