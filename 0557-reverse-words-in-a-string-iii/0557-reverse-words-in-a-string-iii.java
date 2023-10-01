class Solution {
    public String reverseWords(String s) {
        String words[]=s.split(" ");
        // String reverseWord = "";
         StringBuilder sb = new StringBuilder();
        for(String str : words)
        {
           sb.append(new StringBuffer(str).reverse().toString()+" ");
            // sb.reverse();
            // reverseWord = reverseWord + sb.toString()+" ";
            
        }
        // return reverseWord.trim();
        return sb.toString().trim();
    }
}