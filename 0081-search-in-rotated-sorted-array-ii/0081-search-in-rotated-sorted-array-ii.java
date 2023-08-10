class Solution {
    public boolean search(int[] nums, int target) {
        boolean bool = false;
        for(int i:nums)
        {
            if(i==target)
            {
                bool = true;
            }
        }
        return bool;
    }
}