class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
         List<List<Integer>> result = new ArrayList<>();
         backtrack(0,candidates,target,path,result);
         return result;
    }

    private void backtrack(int index, int[] candidates,int target, List<Integer> path , List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;

        }
        if(target < 0){
            return;
        }
        if(index >= candidates.length){
            return;
        }
        for(int i=index;i<candidates.length;i++){

            // to avoid duplicate combination
             if( i>index && candidates[i]==candidates[i-1]){
                continue;
             }   
            if(candidates[i]>target){
                break;
            }
            path.add(candidates[i]);
            backtrack(i+1,candidates,target-candidates[i],path,result);
            path.remove(path.size()-1);
        }
    }
}
