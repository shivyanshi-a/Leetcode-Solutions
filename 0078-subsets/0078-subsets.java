class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int index, int[] nums,
                           List<Integer> temp,
                           List<List<Integer>> ans) {

        ans.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);                   // Choose
            backtrack(i + 1, nums, temp, ans);  // Explore
            temp.remove(temp.size() - 1);       // Backtrack
        }
    }
}