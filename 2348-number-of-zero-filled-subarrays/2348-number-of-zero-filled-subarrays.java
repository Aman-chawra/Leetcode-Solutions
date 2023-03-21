class Solution {
    public long zeroFilledSubarray(int[] nums) {
        ArrayList<Long>list=new ArrayList<>();
        long ans=1;
        long count=2;
        for(int i=1;i<=100000;i++){
            list.add(ans);
            ans+=count;
            count++;
        }
        
        count=0;
        ans=0;
        for(int i=0;i<nums.length;i++){
          if(nums[i]==0){
              count++;
          }  
          else{
              if(count!=0){
              ans+=list.get((int)count-1);
              }
              count=0;
          }
        }
       if(count!=0){
              ans+=list.get((int)count-1);
              }
        return ans;
    }
}