# Zero Matrix

## We're asked to implement an algorithm to nullify every row and column of a matrix that contains a 0

As a first impression, we might think it's a good idea to traverse the matrix and whenever we find a 0 we nullify that row and column. That's not a good idea!
Imagine we find a 0 at (0, 5). If we nullify that row immediately we will then find new zeroes in that row and column that were not there. Soon, the matrix will be filled with zeroes.

The simple fix for that is to save which rows and columns we should nullify.

Let's implement that?

```java
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
```

This would take O(n) space and O(n\*n) time, since we go through all the elements in the matrix
