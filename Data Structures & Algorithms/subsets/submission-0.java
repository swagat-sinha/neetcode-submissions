class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets= new ArrayList<>();
        List<Integer> currSet = new ArrayList<>();
        subsetsHelper(0,currSet,subsets,nums);
        return subsets;
    }
    private void subsetsHelper(
        int i, List<Integer> currSet, List<List<Integer>> subsets, int[] nums) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(currSet));
            return;
        }
        currSet.add(nums[i]);

        subsetsHelper(i + 1, currSet, subsets, nums);
        currSet.remove(currSet.size() - 1);
        subsetsHelper(i + 1, currSet, subsets, nums);
    }
}
