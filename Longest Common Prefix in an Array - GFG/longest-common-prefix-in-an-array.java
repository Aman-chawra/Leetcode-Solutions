//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
        if(n==1)return arr[0];

        String me=arr[0];

        for (String string : arr) {

            String temp=string,me2=me;

            me="";

            while(me2.length()!=0&&temp.length()!=0){

                if(me2.charAt(0)!=temp.charAt(0))break;

                else me+=me2.charAt(0);

                me2=me2.substring(1);

                temp=temp.substring(1); } }

         if(me=="")return "-1";

         return me;
    }
}