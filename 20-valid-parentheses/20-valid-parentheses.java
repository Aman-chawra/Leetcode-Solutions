class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        if(s.length() == 1) return false;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(')
            {
                stk.push(s.charAt(i));
            }
            else 
            {
                if(stk.isEmpty()) return false;
                char c = stk.peek(); stk.pop();
                if((s.charAt(i) == ')' && c == '(') || (s.charAt(i) == '}' && c == '{') || (s.charAt(i) == ']' && c == '['))
                continue;
                else return false;
            }
        }
        if(stk.isEmpty()) return true;
        return false;
    }
        
}