class Solution {
    public int minDeletions(String s) {
        int count[] = new int[26];
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ;i<s.length();i++)
        {
            ++count[s.charAt(i) - 'a'];
        }
        for(int i=0;i<26;i++)
        {
            while(count[i]>0&& !set.add(count[i]))
            {
                --count[i];
                ++result;
            }
        }
        return result;
        
    }
}
