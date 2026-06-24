class Solution {
    public int maxDifference(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        for(char c : s.toCharArray()){
             mp.put(c,mp.getOrDefault(c,0)+1);
        }
       int a1 =Integer.MIN_VALUE;
       int a2 =Integer.MAX_VALUE;

        for(int value : mp.values()){

            if(value%2==0){
              a2=Math.min(a2,value);
            }
            else{
               a1 = Math.max(a1,value);
            }
        }

        return a1-a2;
    }
}