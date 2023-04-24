class Solution {
    public int lastStoneWeight(int[] stones) {
        //                Using List
        // List<Integer> ls = new ArrayList<>();
        // for(int i=0;i<stones.length;i++)
        //     ls.add(stones[i]);
        // while(ls.size()>1)
        // {
        //     Collections.sort(ls);
        //     int y = ls.get(ls.size()-1);
        //     int x = ls.get(ls.size()-2);
        //     ls.remove(new Integer(x));
        //     ls.remove(new Integer(y));
        //     if(x!=y)
        //         ls.add(y-x);
        // }
        // if(ls.isEmpty()) return 0;
        // else return ls.get(0);
        
        //               Using Priority Queue
        var maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i : stones)
            maxHeap.add(i);
        while(maxHeap.size()>1)
        {
            maxHeap.offer(maxHeap.poll()-maxHeap.poll());
        }
        return maxHeap.poll();
    }
}
