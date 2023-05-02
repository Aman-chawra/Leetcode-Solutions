class Solution {
    public int arraySign(int[] nums) {
        int sign =1;
        for(int i:nums)
        {
            if(i==0) return 0;
            if(i<0) 
                sign = sign * -1;
        }
        return sign;
        
        
        // another approach
        
        //         int count = 0;
//         for(int i=0;i<nums.length;i++)
//         {
//             if(nums[i] == 0)
//             {
//                 return 0;
//             }
//             if(nums[i]<0)
//             {
//                 count++;
//             }
            
//         }
//         return count%2==0?1:-1;
    }
//     public int signFunc(int product)
//     {
//         // if(product>=0)
//         // {
//         //     if(product>0) return 1;
//         //     else return 0;
//         // }
//         // else return -1;
//         if(product>0)
//             return 1;
//         else if(product==0)
//             return 0;
//         else 
//             return -1;
        
//     }
}