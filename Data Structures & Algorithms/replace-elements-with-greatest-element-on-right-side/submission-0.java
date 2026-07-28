class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return new int[0];
        }

        if (n == 1) {
            arr[0] = -1;
            return arr;
        }
        int maxSoFar = arr[n-1];
        arr[n - 1] = -1; // because there is no element to the right to the rightmost element
       
        for (int i = n - 2; i >= 0; i--) {

            int currentVal = arr[i];
            arr[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, currentVal);
        }

        return arr;
    }
}