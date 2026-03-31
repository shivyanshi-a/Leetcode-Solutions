class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid; // target achieved
            } 
            else if (nums[mid] < target) {
                low = mid + 1; // right side
            } 
            else {
                high = mid - 1; // left side
            }
        }
        return low; // insert position
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 2;

        int result = obj.searchInsert(nums, target);
        System.out.println("Position: " + result);
    }
}