class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
           char[] chars = s.toCharArray();
           Arrays.sort(chars);
           String key = new String(chars);
           if(!map.containsKey(key)){
                map.put(key,new ArrayList<>()); //if we are checking for the first time
           }
           map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
    // brute force
    // check each string with every other string whether its anagram or not
    //if anagram then it in a sublist
}
