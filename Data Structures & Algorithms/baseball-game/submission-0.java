class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> record = new Stack<>();
        for (String operation : operations) {
            if (operation.equals("C")) {
                record.pop();
            } else if (operation.equals("D")) {
                record.push((record.peek()) * 2);
            } else if (operation.equals("+")) {
                int last = record.pop();
                int secondLast = record.peek();
                record.push(last);
                record.push(last + secondLast);

            } else {
              record.push(Integer.parseInt(operation));
            }
    
        }

        int sum = 0;
      while(!record.isEmpty()){
        sum+= record.pop();
      }
            return sum;
    }


}