class Solution {
    int ans = 0;
    private int Height(TreeNode root){
        if (root == null){
            return 0;
        }
        int lh = Height(root.left);
        int rh = Height(root.right);

        return Math.max(lh,rh) + 1;
    }

    public int deepestLeavesSum(TreeNode root) {
        int h = Height(root);
        Helper(root, h);

        return ans;
    }

    private void Helper(TreeNode root, int height){
        if (root == null){
            return ;
        }
        if ( height == 1){
            ans = ans + root.val;
        }
        Helper(root.left, height - 1);
        Helper(root.right, height - 1);
    }
}