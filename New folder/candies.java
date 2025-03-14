class Solution {
    public int maximumCandies(int[] candies, long k) { 
        int left = 1, right = (int) 1e7; 
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(candies, k, mid)) {
                result = mid; 
                left = mid + 1;
            } else {
                right = mid - 1; // Reduce max candies per child
            }
        }
        
        return result;
    }

    private boolean canDistribute(int[] candies, long k, int mid) {
        long count = 0; 
        for (int candy : candies) {
            count += candy / mid; 
            if (count >= k) return true; 
        }
        return count >= k;
    }
}
