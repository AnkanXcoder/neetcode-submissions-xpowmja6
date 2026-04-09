class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        res[0] = 1;
        for(int i=1;i<n;i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int suffix = 1;
        for(int i=n-1;i>=0;i--) {
            res[i] = res[i] * suffix;
            suffix*=nums[i];
        }
        return res;
    }
}


// res[i] store prefix or left array value and then we multiply right      array or suffix value same as two array concept