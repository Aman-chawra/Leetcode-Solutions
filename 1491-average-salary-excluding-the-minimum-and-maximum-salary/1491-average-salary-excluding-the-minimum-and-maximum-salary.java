class Solution {
    public double average(int[] salary) {
        double num=0;
        Arrays.sort(salary);
        // if(salary.length == 1)
        //     return ;
        for(int i=1;i<salary.length-1;i++)
        {
            num = num + salary[i];
        }
        return num/(salary.length-2);
    }
}