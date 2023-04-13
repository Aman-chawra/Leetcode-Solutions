class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack <Integer> stk = new Stack<>();
        int j =0;
        for(int e : pushed)
        {
            stk.push(e);
            while(!stk.isEmpty() &&  j<popped.length && stk.peek() == popped[j])
            {
                stk.pop();
                j++;
            }
        }
        return  j==popped.length;
    }
}