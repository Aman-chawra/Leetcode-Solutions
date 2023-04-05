class Solution {
    public int partitionString(String s) 
    {
        // int n = 
        int cnt = 1;
        
        boolean elem[] = new boolean[26];

        for (int i = 0; i < s.length(); i++) 
        {
            char c = s.charAt(i);
            
            if(elem[c-'a'])
            {
                Arrays.fill(elem, false);
                elem[c-'a']=true;
                cnt++;
            }
            else
            {
                elem[c-'a']=true;
            }
        }

        return cnt;
    }
}