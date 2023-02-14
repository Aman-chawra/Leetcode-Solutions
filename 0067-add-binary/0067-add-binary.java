import java.math.*;
class Solution {
    public String addBinary(String a, String b) {
        // int carry = 0;
        // int A = a.length()-1;
        // int B = b.length()-1;
        return (new BigInteger(a,2).add(new BigInteger(b,2))).toString(2);
        
        
    }
}