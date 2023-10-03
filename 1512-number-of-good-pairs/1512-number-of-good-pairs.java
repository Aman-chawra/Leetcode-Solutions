class Solution {
    public int numIdenticalPairs(int[] nums) {
    //     int count=0;
    //     for(int i =0 ;i<nums.length;i++)
    //     {
    //         for(int j=0;j<nums.length;j++)
    //         {
    //             if((nums[i] == nums[j]) && i<j)
    //             {
    //                 count++;
    //             }
    //         }
    //     }
    //         return count;
    // }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i : nums)
        {
            if(map.containsKey(i))
            {
                int k = map.get(i);
                res+=k;
                map.put(i,k+1);
            }
            else map.put(i,1);
        }
        return res;
        
    }
        
        
        
}
    

