class Solution {
    public boolean isMonotonic(int[] nums) {
        int n=nums.length;
        if(n<=2) return true;
        int idx=1;
        while(idx<n&&nums[idx]==nums[idx-1]){
            idx++;
        }
        boolean flag=false;
        if(idx<n&&nums[idx]<nums[idx-1]) flag=true;
        for(int i=idx;i<n;i++){
            if(flag==true&&nums[i]>nums[i-1]) return false;
            else if(flag==false&&nums[i]<nums[i-1]) return false;
        }
        return true;

    }
}