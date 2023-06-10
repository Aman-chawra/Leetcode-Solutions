class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long k = ((long)(maxSum/n)) + n;
        long s = 1;
        int leftArrEleCount = index;
        int rightArrEleCount = n-1-index;
        while(s <= k) {
            long m = (s+k)/2;
            long leftSum = getSum(m-1, leftArrEleCount);
            long rightSum = getSum(m-1, rightArrEleCount);
            long total = leftSum+rightSum+m;
            if(total > maxSum) {
                k = m-1;
            } else if(total < maxSum) {
                s = m+1;
            } else {
                return (int) m;
            }
        }
        return (int)s-1;
    }

    private long getSum(long k, int n) {
        long sumOfK = (k *(k+1))/2;
        long sumOfN = 0;
        if(k >= n) {
            sumOfN = sumOfK - ((k - n) *(k-n+1))/2;
        } else {
            sumOfN = sumOfK + (n-k);
        }
        return sumOfN;
    }
}