class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder path = new StringBuilder();
        List<String> result = new ArrayList<>();
        backtrack(digits, path, result, map, 0);
        return result;
    }

    private void backtrack(String digits, StringBuilder path, List<String> result,
        Map<Character, String> map, int index) {
        if (digits.length() == 0) {
            return;
        }
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String characters = map.get(digits.charAt(index));
        for (char ch : characters.toCharArray()) {
            path.append(ch);
            backtrack(digits, path, result, map, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
