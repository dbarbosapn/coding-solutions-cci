public class Solution {

    public static void zeroMatrix(int[][] matrix) {

        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[i] = true;
                }

        nullifyRows(rows, matrix);
        nullifyColumns(columns, matrix);
    }

    private static void nullifyRows(boolean[] rows, int[][] matrix) {
        for(int i = 0; i < rows.length; i++) {
            if(rows[i]) {
                for(int j = 0; j < matrix[i].length; j++)
                    matrix[i][j] = 0;
            }
        }
    }

    private static void nullifyColumns(boolean[] columns, int[][] matrix) {
        for(int j = 0; j < columns.length; j++) {
            if(columns[j]) {
                for(int i = 0; i < matrix.length; i++)
                    matrix[i][j] = 0;
            }
        }
    }

}