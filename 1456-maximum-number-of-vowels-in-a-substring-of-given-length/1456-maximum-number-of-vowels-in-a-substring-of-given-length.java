class Solution {
     public int maxVowels(String s, int k) {
        int currVowel=0, i=0, j=0, ans=0, n=s.length();
        while(j<n){
            if(isVowel(s.charAt(j))) currVowel++;
            if(j-i+1<k) j++;
            else if(j-i+1==k){
                ans=Math.max(ans, currVowel);
               if(isVowel(s.charAt(i))) currVowel--;
                i++;j++;
            } 
        }
        return ans;
    }
    
    boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}