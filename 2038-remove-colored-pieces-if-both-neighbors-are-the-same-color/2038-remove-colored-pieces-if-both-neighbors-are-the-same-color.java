public class Solution {

    public boolean winnerOfGame(String colors) {

        char[] arrayOfColors = colors.toCharArray();
        int arraySize = arrayOfColors.length;
        int numberOfMoves_A = 0;
        int numberOfMoves_B = 0;
        int index = 0;

        while (index < arraySize) {

            int countA = 0;
            while (index < arraySize && arrayOfColors[index] == 'A') {
                countA++;
                index++;
            }
            if (countA > 2) {
                numberOfMoves_A += countA - 2;
            }

            int countB = 0;
            while (index < arraySize && arrayOfColors[index] == 'B') {
                countB++;
                index++;
            }
            if (countB > 2) {
                numberOfMoves_B += countB - 2;
            }

        }
        return numberOfMoves_A > numberOfMoves_B;
    }
}