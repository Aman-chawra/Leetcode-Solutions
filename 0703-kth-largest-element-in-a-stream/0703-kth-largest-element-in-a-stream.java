class KthLargest {
    final PriorityQueue<Integer> que;
    final int k;
    
    public KthLargest(int k, int[] nums) {
    this.k =k;
        que = new PriorityQueue<>(k);
        for(int n:nums)
        {
            add(n);
        }
    }
    
    public int add(int n) {
        if(que.size()<k)
        {
            que.offer(n);
        }
        else if(que.peek() <n)
        {
            que.poll();
            que.offer(n);
            
        }
        return que.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */