class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> mp1 = new HashMap<>();
        Map<Character,Integer> mp2 = new HashMap<>();

        for(char c : s.toCharArray()){
            mp1.put(c,mp1.getOrDefault(c,0)+1);
        }

           for(char c : t.toCharArray()){
            mp2.put(c,mp2.getOrDefault(c,0)+1);
        }

        for( Character key : mp1.keySet()){
            if(!Objects.equals(mp1.get(key), mp2.get(key))){
                return false;
            }
        }

        return mp1.size()==mp2.size();
    }
}
