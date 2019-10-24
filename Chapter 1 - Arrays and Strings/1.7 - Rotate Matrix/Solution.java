public class Solution {

    public static void rotateMatrix(int[][] matrix) {

        for(int layer = 0; layer < matrix.length / 2; layer++) {
            int first = layer;
            int last = matrix.length - 1 - layer;

            for(int i = first; i < last; i++) {
                int offset = i - first;

                // Save the last value
                int tmp = matrix[first][i];

                // Bring left bottom to left top
                matrix[first][i] = matrix[last - offset][first];
                
                // Bring bottom right to bottom left
                matrix[last - offset][first] = matrix[last][last - offset];

                // Bring top right to bottom right
                matrix[last][last - offset] = matrix[i][last];

                // Finally set top right to the saved value
                matrix[i][last] = top;
            }
        }
    }

}