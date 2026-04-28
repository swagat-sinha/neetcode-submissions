class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<Integer> currComb = new ArrayList<>();
        List<List<Integer>> combs = new ArrayList<>();
        combineHelper(1,n,k,currComb,combs);
        return combs;
    }

    private void combineHelper(
        int start, int n, int k, List<Integer> currComb, List<List<Integer>> combs) {
        if (currComb.size() == k) {
            combs.add(new ArrayList<>(currComb));
            return;
        }

        if (start > n) {
            return;
        }

        for (int i = start; i <= n; i++) {
            currComb.add(i);
            combineHelper(i + 1, n, k, currComb, combs);
            currComb.remove(currComb.size() - 1);
        }
    }
}