class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for(char c : sentence.toCharArray())
        {
            set.add(c);
        }
        System.out.println(set);
        if(set.size() == 26)
            return true;
        return false;
    }
}