class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backtrack( 0, 0, path, result,n);
        return result;
    }

    private void backtrack( int openBrackets, int closeBrackets, StringBuilder path,
        List<String> result ,int n) {
        if (path.length() == 2 * n) {
            result.add(path.toString());
            return;
        }

        if(openBrackets<n){
            path.append('(');
            backtrack(openBrackets+1,closeBrackets,path,result,n);
            path.deleteCharAt(path.length()-1);
        }

        if(closeBrackets < openBrackets){
            path.append(')');
            backtrack(openBrackets,closeBrackets+1,path,result,n);
            path.deleteCharAt(path.length()-1);
        }
       
    }
}
