class Solution {
        public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> tt = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                ss.push(s.charAt(i));
            } else if (!ss.isEmpty()) {
                ss.pop();
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                tt.push(t.charAt(i));
            } else if (!tt.isEmpty()) {
                tt.pop();
            }
        }

        StringBuilder ssB = new StringBuilder();
        StringBuilder ttB = new StringBuilder();

        while (!ss.isEmpty()) {
            ssB.append(ss.pop());
        }

        while (!tt.isEmpty()) {
            ttB.append(tt.pop());
        }

        return ssB.toString().equals(ttB.toString());
    }
}