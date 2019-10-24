# Rotate Matrix

## We're asked to implement an algorithm to rotate a matrix 90 degrees.

First solution that comes to my mind is to create a new matrix and as we read the columns, we insert the rows on the new matrix. This would be a O(n) space O(n) time solution.

## This would be great. But then we're asked to make that in place.

The way I would do this is to divide the matrix in "layers". For example, a 4 by 4 matrix would have 2 layers (outer layer and inner layer).
Then we rotate layer by layer. The first number in a layer's row becomes the first in the last column and so on.

Let's implement that?

```java
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
```

This would take O(1) space and O(n\*n) time, since we go through all the elements in the matrix
