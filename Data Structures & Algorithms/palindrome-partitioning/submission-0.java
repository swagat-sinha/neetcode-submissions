class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> substring = new ArrayList<>();
        backtrack(s,0,substring,result);
        return result;
    }

    private void backtrack(String s , int index , List<String> path , List<List<String>> result){


        //base case

        if(index == s.length()){
                result.add(new ArrayList<>(path));
                return;
        }

        for(int i=index;i<s.length();i++){
            
            if(validPallindrome(s.substring(index,i+1))){
                path.add(s.substring(index,i+1));
                backtrack(s, i+1,path,result);
                path.remove(path.size()-1);
            }

        }

  
    }

    private boolean validPallindrome(String str){
        int i =0 , j = str.length()-1;


        while(i<=j){
            if(str.charAt(i)!= str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
