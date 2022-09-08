class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int neg[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=n-2;i>=0;i--)
        {
            while(s.size()>0 && s.peek() <= nums[i])
                {s.pop();}
            s.push(nums[i]);
        }
        for(int i=n-1;i>=0;i--)
        {
            if(s.isEmpty())
            {
                neg[i] = -1;
                s.push(nums[i]);
            }
            else if(nums[i] <s.peek())
            {
                neg[i] = s.peek();
                s.push(nums[i]);
            }
            else
            {
                while(!s.isEmpty() && s.peek() <= nums[i])
                {
                    s.pop();
                }
                if(!s.isEmpty())
                {
                    neg[i] = s.peek();
                }
                else
                {
                    neg[i] = -1;
                    
                }
                s.push(nums[i]);
            }
        }
        
    return neg;
    }
}





/*
        int neg[] = new int[n];
        Stack<Integer> s = new Stack<Integer>();
        for(int i=n-1;i>=0;i--)
        {
            if(s.isEmpty())
            {
                neg[i] = -1;
                s.push(nums[i]);
            }
            else if(nums[i] <s.peek())
            {
                neg[i] = s.peek();
                s.push(nums[i]);
            }
            else
            {
                while(!s.isEmpty() && s.peek() <= nums[i])
                {
                    s.pop();
                }
                if(!s.isEmpty())
                {
                    neg[i] = s.peek();
                }
                else
                {
                    neg[i] = -1;
                    
                }
                s.push(nums[i]);
            }
        }
        
        return neg;
*/