class Solution {
    public boolean detectCapitalUse(String word) {
        
        int count=0, ccount =0 ;
        for(Character c : word.toCharArray())
        {
            if(c >='A' && c<='Z')
                count++;
            else if(c >='a' && c<='z')
                ccount++;
            
        }
        if(count == word.length())
        {
            return true;
        }
        else if(ccount == word.length())
        {
            return true;
        }
        else if((word.charAt(0) >= 'A' && word.charAt(0) <='Z') && ccount == word.length()-1 )
            return true;
        
        return false;
    }
    
}