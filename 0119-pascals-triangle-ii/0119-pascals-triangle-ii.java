class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ary = new ArrayList<Integer>();
        ary.add(1);
        for(int i=1;i<=rowIndex;i++)
        {
            for(int j=i-1;j>=1;j--)
            {
                int temp = ary.get(j-1)+ary.get(j);
                ary.set(j,temp);
            }
            ary.add(1);
            
        }
        return ary;
    }
}