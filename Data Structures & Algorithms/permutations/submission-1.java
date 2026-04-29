class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permutations.add(new ArrayList<>());
        for(int num : nums){
            List<List<Integer>> nextPermutations = new ArrayList<>();
            for(List<Integer> permute : permutations){
                for(int i=0;i<=permute.size();i++){
                    List<Integer> permuteCopy = new ArrayList<>(permute);
                    permuteCopy.add(i,num);
                    nextPermutations.add(permuteCopy);

                }
                permutations = nextPermutations;
            }
        }
        return permutations;
        
    }


}
