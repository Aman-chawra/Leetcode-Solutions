class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[1] = findLast(nums,target);
        result[0] = findFirst(nums,target);
        return result;
    }

private int findFirst(int nums[],int target)
{
    int idx = -1;
    int first = 0;
    int last = nums.length-1;
    while(first <= last)
    {
        int mid =( first+last)/2;
        if(nums[mid] >= target)
        {
            last = mid-1;
        }
        else first = mid+1;
        if(nums[mid] == target) 
            idx = mid;
        
    }
    return idx;
}
    
    private int findLast(int[] nums,int target)
    {
        int idx = -1;
        int first = 0;
        int last = nums.length-1;
        while(first <=last)
        {
            int mid = (first+last)/2;
            if(nums[mid]<=target)
            {
                first = mid+1;
            }
            else last = mid-1;
            if(nums[mid] == target) idx = mid;
        }
                    return idx;
    }
}