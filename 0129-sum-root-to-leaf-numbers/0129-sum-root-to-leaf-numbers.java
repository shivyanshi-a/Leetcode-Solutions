class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int curr) {

        if (root == null)
            return 0;

        curr = curr * 10 + root.val;

        if (root.left == null && root.right == null)
            return curr;

        return dfs(root.left, curr) + dfs(root.right, curr);
    }
}