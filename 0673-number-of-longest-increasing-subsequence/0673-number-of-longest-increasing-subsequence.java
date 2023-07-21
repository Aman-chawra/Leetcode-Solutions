class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length==0){return 0;}
        int[] mark=new int[nums.length];
        int max=nums[0];
        int[][] map=new int[nums.length][];
        for(int i=0;i<nums.length;i++){
            int[] arr = {1,1};
            map[i]=arr;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=max){
                mark[i]=1;
            }else{
                mark[i]=0;
                max=nums[i];
            }
        }
        int max_length=1;
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>-1;j--){
                if(nums[i]<=nums[j]){
                    continue;
                }
                int[] list_i=map[i];
                int[] list_j=map[j];
                if(list_i[0]<1+list_j[0]){
                    list_i[0]=1+list_j[0];
                    list_i[1]=list_j[1];
                    map[i]=list_i;
                }else if(list_i[0]==1+list_j[0]){
                    list_i[1]=list_j[1]+list_i[1];
                    map[i]=list_i;
                }
                if(mark[j]==0){break;}
            }
            if(max_length<map[i][0]){
                max_length=map[i][0];
            }
        }
        int ret=0;
        for(int[] list:map){
            if(list[0]==max_length){
                ret+=list[1];
            }
        }
        return ret;
    }
}