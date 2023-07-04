class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            hmap.put(nums[i], hmap.getOrDefault(nums[i],0)+1);
            
        }
        for(Map.Entry<Integer,Integer> eset : hmap.entrySet()){
            if(eset.getValue() ==1) return eset.getKey();
                
        }
        return 1;
    }
}