class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for(int i =0;i<nums1.length;i++)
        {
            boolean chk=false,chk1=false;
            for(int j=0;j<nums2.length;j++)
            {
                
                if(chk || nums1[i] == nums2[j])
                {
                    chk=true;
                    if(nums1[i]<nums2[j])
                    { 
                        nums1[i] = nums2[j];
                        chk1=true;
                        break;
                    }
                }

            }
            if(!chk1)
                nums1[i]=-1;
        }
        return nums1;
    }
}