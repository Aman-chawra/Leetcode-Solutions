class Solution {
        public String simplifyPath(String path) {
        String[] x = path.split("/");
        StringBuilder sb = new StringBuilder();
        for (int i = x.length - 1, sk = 0; i >= 0; i--) {
            if (x[i].equals(".") || x[i].length() == 0) continue;
            if (x[i].equals("..")) sk++;  // increment skip count 
            else if (sk > 0) sk--;  // skip it
            else sb.insert(0, "/" + x[i]);  // skip = 0? then add it.
        }
        if (sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}