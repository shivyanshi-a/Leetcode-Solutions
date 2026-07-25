class Solution {

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                     0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = build(preorder, preStart + 1,
                          preStart + numsLeft,
                          inStart, inRoot - 1);

        root.right = build(preorder,
                           preStart + numsLeft + 1,
                           preEnd,
                           inRoot + 1,
                           inEnd);

        return root;
    }
}