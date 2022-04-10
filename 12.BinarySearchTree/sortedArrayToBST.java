class sortedArrayToBST {
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


    public TreeNode sortedArrayBST(int[] nums) {
        if(nums.length == 0) return null;
        
        return createBST(nums, 0 , nums.length-1);
    }
    
    public TreeNode createBST(int[] nums , int i , int j){
        if(i > j) return null;
            
        int mid = (i+j)/2;    
        
        TreeNode root = new TreeNode(nums[mid]);
            
        root.left = createBST(nums , i , mid-1);
        root.right = createBST(nums , mid+1 , j);
    
        return root;
    }
}