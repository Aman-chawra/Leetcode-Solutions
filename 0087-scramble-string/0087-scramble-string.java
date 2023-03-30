class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {

        return new Solution().memorization(s1,s2);

    }

        private boolean memorization(String s1, String s2) {
          if (s1.length() == 1) {
            return s1.equals(s2);
        }
        if (s1.equals(s2)) {
            return true;
        }
        String key = s1 + "*" + s2;
        if (map.get(key) != null) {
            return map.get(key);

        }
        int len = s1.length();
        for (int i = 1; i < len; i++) {
            if ((memorization(s1.substring(0, i), s2.substring(0, i))
                    && memorization(s1.substring(i), s2.substring(i))) ||
                    (memorization(s1.substring(0, i), s2.substring(len - i))
                            && memorization(s1.substring(i), s2.substring(0, len - i)))) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}