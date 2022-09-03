class Solution {
    public boolean checkIfPangram(String sentence) {
        // Set<Character> set = new HashSet<>();
        // for(char c : sentence.toCharArray())
        // {
        //     set.add(c);
        // }
        // System.out.println(set);
        // if(set.size() == 26)
        //     return true;
        // return false;
        
        String all = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0;i<all.length();i++)
        {
            if(sentence.indexOf(all.charAt(i)) == -1) return false;
        }
        return true;
    }
}