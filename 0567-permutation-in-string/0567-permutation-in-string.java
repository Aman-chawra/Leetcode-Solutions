class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int count[] =new int[128];
        for(int i=0;i<s1.length();i++)
        {
            count[s1.charAt(i)]--;
        }
        for(int j=0,k=0;k<s2.length();k++)
        {
            if(++count[s2.charAt(k)] > 0)
            {
                while(--count[s2.charAt(j++)] != 0) {}
            }
                else if((k-j+1) == s1.length())
                    return true;
            }
        return s1.length() == 0;
    }
}