class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int next1 = 0;
        int next2 = 0;
        int curr;
        for (int i = n - 1; i >= 0; i--) {
            curr = Math.min(next1, next2) + cost[i];
            next2 = next1;
            next1 = curr;
        }

        return Math.min(next1, next2);
    }
}
