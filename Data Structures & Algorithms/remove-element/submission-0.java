class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                length = deleteElement(nums, i, length);
                i--;
            }
        }
        return length;
    }

    public int deleteElement(int[] nums, int idx, int length) {
        for (int i = idx + 1; i < length; i++) {
            nums[i - 1] = nums[i];
        }
        return length - 1;
    }
}