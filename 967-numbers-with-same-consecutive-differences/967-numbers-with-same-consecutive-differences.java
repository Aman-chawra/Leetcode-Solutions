class Solution {
    List<Integer> res = new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {
        
        for(int i=1;i<=9;i++){
            helper(i,i,k,n-1);
        }
        
        int[] ans = new int[res.size()];
        
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        
        return ans;
    }
    
    public void helper(int i,int num, int k, int n){
        
        if(n==0){
            if(!res.contains(num))
                res.add(num);
            return;
        }
        if(i-k>=0){
            helper(i-k,num*10+i-k,k,n-1);
        }
        if(i+k<=9){
            helper(i+k,num*10+i+k,k,n-1);
        }
    }
}