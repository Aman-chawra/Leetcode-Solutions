class Solution {
    public long mostPoints(int[][] questions) {
        long[] vals= new long[questions.length];                        //to store the max points
        vals[questions.length-1]= questions[questions.length-1][0];     //starting from the end

        for(int r=questions.length-2;r>=0;r--){         //looping  from 2nd last
            long temp= questions[r][0];                 //for current row points
            int skip= questions[r][1];
            if(r+skip+1 < questions.length)             //adding next unskipped points to the current row
                temp+= vals[r+skip+1];
            vals[r]= Math.max(temp,vals[r+1]);          //assigning the max val among current or next row
        }
        return vals[0];             //the max val is stored at the 0th index of the vals
    }
}