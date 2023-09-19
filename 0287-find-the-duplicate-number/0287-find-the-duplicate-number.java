class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i:nums) hm.put(i,hm.getOrDefault(i,0)+1);
        System.out.println(hm);
        int num=0;
        for(int i:nums)
        {
            if(hm.get(i) >= 2) num = i;
        }
        return num;
        // Arrays.sort(nums);
        // int num =0;
        // for(int i=0;i<nums.length-1;i++)
        // {
        //     if(nums[i] == nums[i+1])  num = nums[i];
        // }
        // return num;
        
    }
}