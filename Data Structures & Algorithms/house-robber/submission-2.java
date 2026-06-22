class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length+2];
        Arrays.fill(dp,-1);
        return solve(nums,0);
    }

    private int solve(int [] nums ,int i){

        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int canRob = solve(nums,i+2) + nums[i];
        int skip = solve(nums,i+1);

        dp[i] = Math.max(canRob,skip);
        return dp[i];
    }
}
