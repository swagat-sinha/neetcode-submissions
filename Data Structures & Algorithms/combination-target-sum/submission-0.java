class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(0,nums,target,path,combinations);
        return combinations;
    }
    private void  backtrack(int start , int []nums , int target ,List<Integer> path ,List<List<Integer>> combinations){

        if(target==0){
            combinations.add(new ArrayList<>(path));
            return;
        }
        if(target <0){
            return;
        }


        for(int i = start ;i<nums.length;i++){
            path.add(nums[i]);
            backtrack(i,nums,target-nums[i],path,combinations);
            path.remove(path.size()-1);
            
        }


    }
}
