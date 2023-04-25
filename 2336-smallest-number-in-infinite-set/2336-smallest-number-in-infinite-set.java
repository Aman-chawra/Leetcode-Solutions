class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    HashSet<Integer> set;
    int curr;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        curr = 1;
    }
    
    public int popSmallest() {
        if(pq.isEmpty())
            return curr++;
        
        set.remove(pq.peek());
        return pq.remove();
        
    }
    
    public void addBack(int num) {
        if(num < curr) {
            int prevSize = set.size();
            set.add(num);
            if(set.size() > prevSize)
                pq.add(num);
        }
    }
}
/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */