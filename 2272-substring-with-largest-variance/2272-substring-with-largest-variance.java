class Solution {
    public int largestVariance(String s) {
        int max = 0;     
        boolean exist[] = new boolean [26];
        for (int i= 0 ; i < 26 ; i++) exist[i] = s.indexOf('a'+i) != -1;
        for (char first = 'a'; first <= 'z' ; first ++){
            if (!exist[first-'a']) continue;
            for (char sec = 'a' ; sec <= 'z' ; sec ++){
                if (!exist[sec-'a'] || sec == first) continue;
                int count = 0;
                boolean secInc = false;
                for (char c: s.toCharArray()){
                    if (c==first) count++;
                    if (c==sec) {
                        count--;
                        if (count >= 0) secInc = true;
                        else {
                             secInc = false;
                             count = 0;
                        }
                    }
                    if (secInc) max = Math.max (max, count);
                }
                if (count > 1 && !secInc && count < s.length()) max = Math.max (max, count - 1);
            }
        }
        return max;
    }
}