class Solution {
    public int maxDifference(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        for(char c : s.toCharArray()){
             mp.put(c,mp.getOrDefault(c,0)+1);
        }
       int a1 =Integer.MIN_VALUE;
       int a2 =Integer.MAX_VALUE;

        for(Map.Entry<Character,Integer> entry : mp.entrySet()){

            if(entry.getValue()%2==0){
              a2=Math.min(a2,entry.getValue());
            }
            else{
               a1 = Math.max(a1,entry.getValue());
            }
        }

        return a1-a2;
    }
}