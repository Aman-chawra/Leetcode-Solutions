class Solution {
    public int searchInsert(int[] nums, int target) {
        int index= 0 ;
        for(int i=0; i<nums.length;i++)
        {
            if(target<=nums[i])
                return index;
            else
                index++;
            
        }
        return index;
        
        
    }
}