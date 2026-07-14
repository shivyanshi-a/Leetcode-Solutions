class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] candidates, int target, int index,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // Found a valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Invalid case
        if (target < 0 || index == candidates.length)
            return;

        // Include current element
        current.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, current, ans);

        // Backtrack
        current.remove(current.size() - 1);

        // Exclude current element
        backtrack(candidates, target, index + 1, current, ans);
    }
}