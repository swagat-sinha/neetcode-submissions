class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
         for(int num : nums){
            int currFreq = mp.getOrDefault(num,0);
            if(currFreq>=1){
                return true;
            }

            mp.put(num,currFreq+1);
         }
         return false;
    }
}
