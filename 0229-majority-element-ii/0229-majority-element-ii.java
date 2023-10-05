import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int times=nums.length/3;
        List<Integer> ret=new ArrayList<>();
        int candidate1=0;
        int cnt1=0;
        int candidate2=0;
        int cnt2=0;
        for(int n:nums){
            if(n==candidate1){
                cnt1++;
            }else if(n==candidate2){
                cnt2++;
            }else if(cnt1==0){
                candidate1=n;
                cnt1++;
            }else if(cnt2==0){
                candidate2=n;
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int n:nums){
            if(n==candidate1){
                cnt1++;
            }else if(n==candidate2) {
                cnt2++;
            }
        }
        if(cnt1>times){
            ret.add(candidate1);
        }
        if(cnt2>times){
            ret.add(candidate2);
        }
        return ret;
    }
}