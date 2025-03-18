class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n=nums.length;
        int maxLen=0;
        for(int i=0;i<n;i++){
            int bitMask=0;
            for(int j=i;j<n;j++){
                if((bitMask & nums[j])!=0){
                    break;
                }
                bitMask |=nums[j];
                maxLen=Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
}