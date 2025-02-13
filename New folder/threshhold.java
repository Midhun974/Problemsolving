class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap=new PriorityQueue<>();
        for(int num:nums){
            minHeap.offer((long)num);
        }
        int count=0;
        while(minHeap.size()>=2){
            if(minHeap.peek()>=k){
                return count;
            }
            count++;
            long x=minHeap.poll();
            long y=minHeap.poll();
            minHeap.offer(x*2+y);
        }
        return count;
    }
}