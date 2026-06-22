class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int next1 = 0;
        int next2 = 0;
        int curr;
        for (int i = n - 1; i >= 0; i--) {
            curr = next2 + nums[i];
            curr = Math.max(curr, next1);
            next2 = next1;
            next1 = curr;
        }
        return next1;
    }
}
