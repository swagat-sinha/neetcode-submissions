class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Boolean> mp = new HashMap<>();

        for(int num : nums){
            if(mp.containsKey(num)){
                return true;
            }
            mp.put(num,true);
        }
        return false;
    }
}