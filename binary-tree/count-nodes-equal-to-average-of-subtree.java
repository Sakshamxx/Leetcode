class Solution {
    int ans = 0;

    class Info {
        int sum;
        int count;
        Info(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private Info dfs(TreeNode node) {
        if (node == null) {
            return new Info(0, 0);
        }
        Info left = dfs(node.left);
        Info right = dfs(node.right);
        int sum = left.sum + right.sum + node.val;
        int count = left.count + right.count + 1;
        if (node.val == sum / count) {
            ans++;
        }
        return new Info(sum, count);
    }
}