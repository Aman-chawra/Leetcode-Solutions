class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0,j=0,x = word1.length(),y = word2.length();
        StringBuilder sb = new StringBuilder();
        while(i<x || j<y)
        {
            if(i<x)
            {
                sb.append(word1.charAt(i++));
            }
            if(j<y)
            {
                sb.append(word2.charAt(j++));
            }
        }
        return sb.toString();
    }
}