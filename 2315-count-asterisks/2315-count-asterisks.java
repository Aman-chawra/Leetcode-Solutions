class Solution {
    public int countAsterisks(String s) {
        Stack<Character> stk = new Stack<>();
        int cnt=0;
        int temp =0;
        for(char c : s.toCharArray())
        {
            if(c == '|')
            {
                if(stk.size() == 1)
                {
                    stk.pop();
                }
                else
                {
                    cnt = cnt+temp;
                    stk.push('|');
                }
                temp=0;
            }
            else
            {
                if(c == '*') temp++;
            }    
        }
        cnt = cnt+temp;
        return cnt;
    }
}