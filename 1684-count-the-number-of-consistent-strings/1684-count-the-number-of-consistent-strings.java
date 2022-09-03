class Solution {

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> st = new HashSet<>();
        int cnt = 0;
        for (char c : allowed.toCharArray()) st.add(c);
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                if (!st.contains(s.charAt(i))) break;
                if (i == s.length() - 1) cnt++;
            }
        }
        return cnt;
    }
}
