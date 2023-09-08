class Solution {
   public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();

        list.add(1);
        lists.add(list);
        if (numRows == 1) return lists;
        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        lists.add(list);
        if (numRows == 2) return lists;

        for (int i = 2; i < numRows; i++) {
            list = new ArrayList<>();
            List<Integer> prevList = lists.get(i - 1);
            Integer prev = 0;
            for (Integer next:prevList) {
                list.add(prev + next);
                prev = next;                
            }
            list.add(1);
            lists.add(list);
        }
        return lists;
    }
}