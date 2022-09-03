class Solution {
    public String truncateSentence(String s, int k) {
        String ch[] = s.split(" ");
        String ans = "";
        int num=0;
        while(num<k){
            ans+=ch[num]+" ";
            num++;
        }
        
        return ans.trim();
    }
}