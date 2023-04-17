class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
                ArrayList<Boolean> res = new ArrayList<>(candies.length);
        int max= Integer.MIN_VALUE;
        for(int cdy : candies)
            max = Math.max(max,cdy);
        for(int cdy : candies)
            res.add((cdy + extraCandies)>=max);
        return res;
            
            
        
    }
}