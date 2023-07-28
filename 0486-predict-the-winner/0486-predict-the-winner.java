class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return canWin(nums, 0, nums.length-1, 1, 0);
    }
    
    public boolean canWin(int[] nums, int l, int h, int sum1, int sum2){
        if(l == h)
            return sum1+nums[l] > sum2;
        
        return !canWin(nums, l+1, h, sum2, sum1+nums[l]) || !canWin(nums, l, h-1, sum2, sum1+nums[h]);
    }
}