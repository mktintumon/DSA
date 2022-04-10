class lowestCommonAncestorBST {
        
    //   ITERATIVE METHOD    
       
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr != null){
            if(p.val < curr.val && q.val < curr.val){
                curr = curr.left;
            }
            else if(p.val > curr.val && q.val > curr.val){
                curr = curr.right;
            }
            else{
                //divergent
                return curr;
            }
        }
        
        return null;
    }
}



/*     RECURSIVE METHOD


public static int lca(Node node, int d1, int d2) {
    if(node == null) return 0;

    if(d1 < node.data && d2 < node.data){
       return lca(node.left , d1 , d2);
    }
    else if(d1 > node.data && d2 > node.data){
       return lca(node.right , d1 , d2);
    }
    else{
       return node.data;
    }
 }

 */