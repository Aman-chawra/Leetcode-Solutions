class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> ls1=new HashSet<>();
        Set<Integer> ls2=new HashSet<>();
        List<Integer> ls3=new ArrayList<>();
        List<Integer> ls4=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        int l1=nums1.length;
        int l2=nums2.length;
         for(int i=0;i<l1;i++){
                ls1.add(nums1[i]);
                
            }
            for(int i=0;i<l2;i++){
               
                ls2.add(nums2[i]);
            }
        if(l1==l2){
           
            for(int i=0;i<l1;i++){
                if(!ls2.contains(nums1[i]) && !ls3.contains(nums1[i])){
                
                ls3.add(nums1[i]);
                }
                if(!ls1.contains(nums2[i]) && !ls4.contains(nums2[i])){
                
                ls4.add(nums2[i]);
                }
            }
        }else if(l1>l2){
            for(int i=0;i<l1;i++){
                if(!ls2.contains(nums1[i]) && !ls3.contains(nums1[i])){
                
                ls3.add(nums1[i]);
                }
                if(i<l2){
                if(!ls1.contains(nums2[i]) && !ls4.contains(nums2[i])){
                
                ls4.add(nums2[i]);
                }
                }
            }

        }else if(l1<l2){
            for(int i=0;i<l2;i++){
                if(i<l1){
                if(!ls2.contains(nums1[i]) && !ls3.contains(nums1[i])){
                
                ls3.add(nums1[i]);
                }
                }
              
                if(!ls1.contains(nums2[i]) && !ls4.contains(nums2[i])){
                
                ls4.add(nums2[i]);
                
                }
            }

        }
        res.add(ls3);
        res.add(ls4);
        
        return res;
        
    }
}