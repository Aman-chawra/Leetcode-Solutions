class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=0; i<words.length-1;i++)
        {
            boolean simple = true;
            String a = words[i], b = words[i+1];
            for(int k=0;k<Math.min(a.length(),b.length());k++)
            {
                if(a.charAt(k) != b.charAt(k))
                {
                    simple = false;
                    int idx_a = order.indexOf(a.charAt(k));
                    int idx_b = order.indexOf(b.charAt(k));
                    if(idx_b<idx_a)
                    {
                        return false;
                    }
                    break;
                }
            }
            if(simple && a.length() > b.length())
                return false;
        }
        return true;
        
        
        
        
        
    }
}
