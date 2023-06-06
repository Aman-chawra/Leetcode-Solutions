class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        // Arrays.sort(arr);
        // for(int i=2;i<arr.length;i++)
        //     if(arr[i]-arr[i-1] != arr[i-1]-arr[i-2]) return false;
        //     return true;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len = arr.length;
        for(int i:arr)
        {
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        if((max-min)%(len-1)!=0)
            return false;
        int step = (max - min)/(len-1);
        if(step==0)
            return true;
        Set<Integer> set = new HashSet<>();
        for(int num:arr)
        {
            if((num-min)%step!=0)
                return false;
            if(!set.add(num))
                return false;
        }
        return true;
        
    }
}