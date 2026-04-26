class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> currSet = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        subsetsHelper(0,currSet,subsets,nums);
        return subsets;
        
    }
    private void subsetsHelper(int i ,List<Integer> currSet, List<List<Integer>> subsets,int[] nums){

        //base case
        if(i>=nums.length){
            subsets.add(new ArrayList<>(currSet));
            return;
        }
        
        currSet.add(nums[i]);
        subsetsHelper(i+1,currSet,subsets,nums);
        currSet.remove(currSet.size()-1);    

        while( i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }
        subsetsHelper(i+1,currSet,subsets,nums);
        
    }
}
