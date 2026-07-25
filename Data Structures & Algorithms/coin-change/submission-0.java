class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        return coinChangeHelper(coins, amount, dp);
    }

    private int coinChangeHelper(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        if (dp[amount] != -2) {
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
           int ans = coinChangeHelper(coins, amount - coin, dp);
            if (ans != -1) {
                min = Math.min(ans+1, min);
            }
        }
        if (min == Integer.MAX_VALUE) {
            dp[amount] = -1;
        } else {
            dp[amount] = min;
        }
        return dp[amount];
    }
}
