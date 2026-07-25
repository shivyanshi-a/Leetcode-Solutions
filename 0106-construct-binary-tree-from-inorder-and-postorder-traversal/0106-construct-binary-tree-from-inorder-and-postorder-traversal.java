class Solution {

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1,
                     postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = map.get(root.val);
        int leftSize = inRoot - inStart;

        root.left = build(inorder, inStart, inRoot - 1,
                          postorder, postStart,
                          postStart + leftSize - 1);

        root.right = build(inorder, inRoot + 1, inEnd,
                           postorder, postStart + leftSize,
                           postEnd - 1);

        return root;
    }
}