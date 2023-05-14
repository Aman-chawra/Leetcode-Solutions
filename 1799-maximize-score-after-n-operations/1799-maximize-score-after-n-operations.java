class Solution {
    Map<Integer, Integer> dp = new HashMap<>();
    public int process(int[] nums, int op, int mask){
        int n = nums.length/2;


        // To Avoid duplicate computations
        if(dp.containsKey(mask)){
            return dp.get(mask);
        }
        // Case when we have done necessary operations
        if(op>n){
            return 0;
        }
        int ans = 0;

        // We iterate through each pair of numbers
        for(int i=0;i<2*n;i++){
            for(int j = i+1; j<2*n;j++){
                // We use mask as a way to track which number got picked and which wasn't
                // We see if ith bit is set and jth bit is set using and(&)
                if(((mask&(1<<i))>0) || ((mask&(1<<j))>0))
                    // If any of the two numbers is already used, we cannot use it again, so continue
                    continue;
                int newMask = mask|(1<<i)|(1<<j);

                // #If both are not used, we can use them and see what the result is and update if it is the maximum
                ans = Math.max(ans, op*gcd(nums[i],nums[j])+process(nums, op+1, newMask));
            }
        }
        dp.put(mask, ans);
        return ans;
    }
    public int maxScore(int[] nums) {
        return process(nums, 1, 0);        
    }
    public int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}