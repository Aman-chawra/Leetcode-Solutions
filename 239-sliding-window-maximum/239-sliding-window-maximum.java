class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max =0;
        int ans[] = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!dq.isEmpty() && dq.peek() == i-k)
            {
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
            {
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1)
            {
                ans[max++] = nums[dq.peek()];
            }
            
        }
        return ans;
    }
}