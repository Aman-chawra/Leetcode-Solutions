class Solution {
    public int addDigits(int num) {
         if(num ==0) return 0;
        while(num>9)
        {
            int a = num%10;
            int b = num/10;
            num= a+b;
        }
        return num;
    }
}