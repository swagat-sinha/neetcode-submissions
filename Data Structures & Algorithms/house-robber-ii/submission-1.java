class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n + 2][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, false);
    }

    private int solve(int[] nums, int i, boolean isFirstRobbed) {
        if (i >= nums.length) {
            return 0;
        }

        int state = isFirstRobbed ? 1 : 0;

        if (dp[i][state] != -1) {
            return dp[i][state];
        }
        int rob =  0;
        int skip = solve( nums,i+1,isFirstRobbed);
        if (i == 0) {
            rob = solve(nums,2,true) + nums[0];
        } else if (i == nums.length - 1) {
            if(!isFirstRobbed){
                rob = solve(nums,i+2,isFirstRobbed) + nums[i];
            }
            
        } else {

             rob = solve(nums,i+2,isFirstRobbed) + nums[i];
        }

        dp[i][state] = Math.max(rob,skip);
        return dp[i][state];
    }
}
