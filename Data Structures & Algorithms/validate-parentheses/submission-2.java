class Solution {
    Map<Character, Character> mp = new HashMap<>();

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        mp.put('(', ')');
        mp.put('{', '}');
        mp.put('[', ']');

        for (char ch : s.toCharArray()) {
            if (isOpeningBracket(ch)) {
                st.push(ch);
            } else {
                if(st.isEmpty()){
                    return false;
                }
                if ( !isMatchingBracket(st.peek(), ch)) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }

    private boolean isOpeningBracket(char ch) {
    
        return ch == '(' || ch == '{' || ch == '[' ;
    }

    private boolean isMatchingBracket(char a, char b) {
        if (!mp.get(a).equals(b)) {
            return false;
        }
        return true;
    }
}
