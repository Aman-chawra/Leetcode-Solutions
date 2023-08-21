class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s != null && s.length() > 1){
            char[] ch = s.toCharArray();
            int N = ch.length;
            
            for(int i = 1; i <= (N/2); i++){
                if(isRepeated(ch, N, i))
                    return true;
            }
            
            return false;
        }else
            return false;
    }
    
    private boolean isRepeated(char[] s, int N, int M){
        if(N % M == 0){
            for(int i = M; i < N; i++){
                if(s[i] != s[i % M])
                    return false;
            }
            
            return true;
        }else
            return false;
    }
}