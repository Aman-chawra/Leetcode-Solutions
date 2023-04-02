class Solution {
    public int binarySearch(int[]arr , int target){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[]arr = new int[spells.length];
        
        int maxPotion = potions[potions.length-1];
        for(int i = 0;i<spells.length;i++){

            long minPotion = (long) Math.ceil((1.0 * success) / spells[i]);
            if (minPotion > maxPotion) {
                continue;
            }

            int pos = binarySearch(potions,(int) minPotion);

            if(pos != -1){
                arr[i] = potions.length - pos;
            }
        }
        return arr;
    }
}