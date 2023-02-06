class Solution {
    public int[] shuffle(int[] nums, int n) {
        // int arr[] = new int[2*n];
        // int j =0;
        //     for(int i=0;i<2*n;i=i+2)
        //     {
        //         arr[i] = nums[j];
        //         arr[i+1] = nums[j+n];
        //         j++;
        //     }
        // return arr;
        
        for(int i=0;i<n;i++)
        {
            nums[i+n] = nums[i+n] + nums[i]*1005;
        }
        for(int i =0; i<n;i++)
        {
            nums[2*i] = nums[i+n] / 1005;
            nums[2*i+1] = nums[i+n] % 1005;
        }
        return nums;
    }
}