class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permuteHelper(nums,0);
    }

    private List<List<Integer>> permuteHelper(int []nums , int i){

        //base case
        if(i>=nums.length){
            List<List<Integer>> resultList = new ArrayList<>();
            resultList.add(new ArrayList<>());
            return  resultList;
        }

      List<List<Integer>> permutations =  permuteHelper(nums,i+1);
      List<List<Integer>>resultPermutations = new ArrayList<>();
     for( List<Integer> permute : permutations){
        for(int j=0;j<=permute.size();j++){
            List<Integer> permuteCopy = new ArrayList<>(permute);
            permuteCopy.add(j,nums[i]);
            resultPermutations.add(permuteCopy);
        }
      }

        return resultPermutations;
    }
}
