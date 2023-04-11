class Solution {
    public String removeStars(String s) {
        char c[]=s.toCharArray();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<c.length;i++){
            if(c[i]=='*'){
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                sb.append(c[i]);
            }
        }

        return sb.toString();
    }
}