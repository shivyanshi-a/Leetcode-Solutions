class Solution {

    int[][] dp;

    public int maximumScore(int[] nums, int[] multipliers) {

        int m = multipliers.length;

        dp = new int[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return solve(0, 0, nums, multipliers);
    }

    private int solve(int left, int idx, int[] nums, int[] mult) {

        if (idx == mult.length)
            return 0;

        if (dp[left][idx] != Integer.MIN_VALUE)
            return dp[left][idx];

        int right = nums.length - 1 - (idx - left);

        int takeLeft = nums[left] * mult[idx]
                + solve(left + 1, idx + 1, nums, mult);

        int takeRight = nums[right] * mult[idx]
                + solve(left, idx + 1, nums, mult);

        return dp[left][idx] = Math.max(takeLeft, takeRight);
    }
}