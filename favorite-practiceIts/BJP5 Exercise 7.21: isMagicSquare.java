/*
Write a method called isMagicSquare that accepts a two-dimensional array of integers
as a parameter and returns true if it is a magic square. A square matrix is a magic square
if it is square in shape (same number of rows as columns, and every row the same length), 
and all of its row, column, and diagonal sums are equal. For example, [[2, 7, 6], [9, 5, 1], [4, 3, 8]] 
is a magic square because all eight of the sums are exactly 15.
*/
public static boolean isMagicSquare(int[][] arr) {
    if (arr.length == 0)
        return true;

    for (int i = 0; i < arr.length; i++) {
        if (arr.length != arr[i].length)
            return false;
    }

    int targetSum = 0;
    for (int i = 0; i < arr[0].length; i++) {
        targetSum += arr[0][i];
    }

    int rowSum, colSum;

    for (int r = 0; r < arr.length; r++) {
        rowSum = 0;
        for (int c = 0; c < arr[0].length; c++) {
            rowSum += arr[r][c];
        }
        if (rowSum != targetSum) {
            return false;
        }
    }

    for (int c = 0; c < arr[0].length; c++) {
        colSum = 0;
        for (int r = 0; r < arr.length; r++) {
            colSum += arr[r][c];
        }
        if (colSum != targetSum) {
            return false;
        }
    }

    int diagSum1 = 0;
    for (int i = 0; i < arr.length; i++) {
        diagSum1 += arr[i][i];
    }
    if (diagSum1 != targetSum) {
        return false;
    }

    int diagSum2 = 0;
    for (int i = 0; i < arr.length; i++) {
        diagSum2 += arr[i][arr.length - 1 - i];
    }
    if (diagSum2 != targetSum) {
        return false;
    }

    return true;
}
