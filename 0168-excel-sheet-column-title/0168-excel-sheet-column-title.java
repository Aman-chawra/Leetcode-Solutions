class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int x,y;
        
        while(columnNumber!=0)
        {
            x = columnNumber%26;
            if(x==0) x=26;
            y = x+'A'-1;
            sb.append((char)(y));
            columnNumber=columnNumber-x;
            columnNumber=columnNumber/26;
            
        }
        String res = new String(sb.reverse());
        return res;
    }
}