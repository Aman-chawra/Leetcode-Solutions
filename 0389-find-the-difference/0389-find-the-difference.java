class Solution {
    public char findTheDifference(String s, String t) {
        char ch = 0;
        for(char c1 : s.toCharArray()) ch ^= c1;
        for(char c2 : t.toCharArray()) ch ^= c2;
        return ch;
    }
}
