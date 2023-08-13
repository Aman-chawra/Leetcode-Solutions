class Solution {
  boolean flag;
  
  public boolean validPartition(int[] nums) {
    flag = false;
    helper(nums, 0);
    return flag;
  }
  
  void helper(int[] nums, int id){
    if(flag) return; 
    
    for(int i = id; i < nums.length && flag == false;){
      int j = i + 1;
      while(j != nums.length && nums[j] == nums[i]) j++;
      
      int dif = j - i;
      if(dif == 2){i = j; continue;}
      if(dif == 1){
        if(i + 2 >= nums.length || nums[i]+1 != nums[i+1] || nums[i+1]+1 != nums[i+2] ) return;
        i += 3; continue;
      }
      i = j;
      helper(nums, i - 1);
    }
    
    flag = true;
  }
}