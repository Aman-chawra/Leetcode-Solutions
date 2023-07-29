
class Solution {
    public double soupServings(int n) {
        if (n>5500) return 1;
        if (n==0) return 0.5;
        int totalSoup = 0 , maxTruns = n/25 + 1;
        double ans = 0, soupA [][] = new double[n+100][maxTruns+1]; // prob of I soup in A after the j turns
        soupA[0][0] = 1;
        for (int j = 1; j <= maxTruns; j++){    
            for (int i = 0; i <= n+99 ; i+=25){
                int soupB = j * 100 - i; // 100 per turn total - i soup in A = soup in B
                if (soupB < 0) continue;
                if (i-25 >=0 && i-25 < n && soupB - 75 < n)  { // a - 25 , b - 75
                    soupA[i][j] =  soupA[i-25][j-1] * 0.25;
                    if (i >= n && soupB >= n) {
                        ans += soupA[i][j] / 2; // both a and b reach n at this turn
                        soupA[i][j] = 0;
                    }
                }
                if (i-50 >=0 && i-50 < n && soupB - 50 < n) { // a - 50 , b - 50
                    soupA[i][j] += soupA[i-50][j-1] * 0.25; 
                    if (i >= n && soupB >= n) {
                        ans += soupA[i][j] / 2; // both a and b reach n at this turn
                        soupA[i][j] = 0;   
                    }
                }
                if (i-75 >=0 && i-75 < n && soupB - 25 < n) { // a - 75 , b - 25
                    soupA[i][j] += soupA[i-75][j-1] * 0.25; 
                    if (i >= n && soupB >= n){
                        ans += soupA[i][j] / 2; // both a and b reach n at this turn
                        soupA[i][j] = 0;   
                    }
                }
                if (i-100 >=0 && soupB < n)  soupA[i][j] += soupA[i-100][j-1] * 0.25;  // a - 100 , b - 0
                if (i >= n && soupB < n) ans += soupA[i][j];
            }
        }
        return ans;
    }
}