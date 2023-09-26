class Solution {
    public String removeDuplicateLetters(String s) {
        // StringBuilder sb = new StringBuilder();
        // s.chars().distinct().forEach(c->sb.append((char)c));
        // return sb.toString();
        
        int [] lastIdx = new int [26];
        for(int i =0;i<s.length();i++)
        {
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        boolean[] bol = new boolean[26];
        Stack<Integer> stk = new Stack<>();
        for(int i=0 ; i<s.length();i++)
        {
            int nows = s.charAt(i) - 'a';
            if(bol[nows]) continue;
            while(!stk.isEmpty() && stk.peek() > nows && i < lastIdx[stk.peek()])
            {
                bol[stk.pop()] = false;
            }
            stk.push(nows);
            bol[nows] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty())
            sb.append((char)(stk.pop()+ 'a'));
        return sb.reverse().toString();

        
    }
}