class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length-1];
        while (r > l){
            int guess = (r+l)/2;
            if (solve(nums,p,guess)) r = guess;
            else l = guess + 1;
        }        
        return l;
    }

    private boolean solve(int[] nums, int p, int maxPair){
        int pairs = 0;
        for (int i = 1 ; i < nums.length; i++){
            if (nums[i] - nums[i-1] <= maxPair) {
                pairs++;
                if (pairs == p) return true;
                i++;
            }
        }
        return false;
    }
}