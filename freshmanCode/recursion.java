/*
1. Permutations of a List
Explanation:

Given a list of distinct integers, generate all possible permutations.
Use backtracking to construct permutations step by step.
A boolean array used[] ensures elements are not repeated in a permutation.
The recursion tree explores all orderings, and backtracking removes elements when exploring other branches.
*/
  
import java.util.*;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        // Base case: If the current path contains all numbers, add to result
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Try each unused number in the sequence
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) { // Ensure we don't use the same number twice
                used[i] = true;
                path.add(nums[i]); // Choose
                backtrack(nums, path, used, result); // Explore
                path.remove(path.size() - 1); // Undo (Backtrack)
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}

/*
2. Generate Valid Parentheses
Explanation:

Given n pairs of parentheses, generate all valid combinations.
At each step, decide whether to add an open ( or a close ), ensuring balance.
Open parentheses can be added as long as they don’t exceed n.
A close parenthesis can be added only if close < open.
*/

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: If the string has the required length, add it to the result
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        // Try adding an open parenthesis if we haven't used all
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        // Try adding a closing parenthesis only if there are open ones to match
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}

/*
3. N-Queens Problem
Explanation:

Place n queens on an n × n board so that no two queens attack each other.
A queen can attack in rows, columns, and diagonals.
Use backtracking to try placing queens row by row.
A helper function checks if a queen placement is valid.
*/
public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(result, board, 0);
        return result;
    }

    private static void backtrack(List<List<String>> result, char[][] board, int row) {
        // Base case: If all rows are filled, add the board to results
        if (row == board.length) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) solution.add(new String(r));
            result.add(solution);
            return;
        }
        // Try placing a queen in each column of the current row
        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) { // Check constraints
                board[row][col] = 'Q'; // Choose
                backtrack(result, board, row + 1); // Explore next row
                board[row][col] = '.'; // Undo (Backtrack)
            }
        }
    }

    private static boolean isValid(char[][] board, int row, int col) {
        // Check vertical column, left diagonal, and right diagonal
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q' ||
                (col - (row - i) >= 0 && board[i][col - (row - i)] == 'Q') ||
                (col + (row - i) < board.length && board[i][col + (row - i)] == 'Q')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}

/*
4. Maze Solving (Rat in a Maze)
Explanation:

Find all paths from the top-left to the bottom-right of a grid.
Can only move right or down.
A boolean visited[][] prevents revisiting cells.
Recursive function explores all possible paths and backtracks when needed.
*/
public class MazeSolver {
    public static List<List<int[]>> solveMaze(int[][] maze) {
        List<List<int[]>> result = new ArrayList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        backtrack(maze, 0, 0, new ArrayList<>(), result, visited);
        return result;
    }

    private static void backtrack(int[][] maze, int x, int y, List<int[]> path, List<List<int[]>> result, boolean[][] visited) {
        // Base case: If we reach the bottom-right cell, add the path
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            path.add(new int[]{x, y});
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        // Boundary and obstacle check
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == 1 || visited[x][y]) return;

        visited[x][y] = true; // Mark as visited
        path.add(new int[]{x, y});
        // Move in all possible directions
        backtrack(maze, x + 1, y, path, result, visited);
        backtrack(maze, x, y + 1, path, result, visited);
        path.remove(path.size() - 1); // Undo (Backtrack)
        visited[x][y] = false;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {0, 0, 1},
            {1, 0, 0},
            {0, 0, 0}
        };
        System.out.println(solveMaze(maze));
    }
}

/**
 * Problem 5: Combination Sum
 * Given an array of unique integers (candidates) and a target value,
 * find all unique combinations in candidates where the candidate numbers
 * sum to the target. Each number can be used unlimited times.
 * This problem is solved using backtracking.
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int start, int target, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) { // Base case: if target is met, add the current path to result
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target >= candidates[i]) { // Only proceed if the target is not exceeded
                path.add(candidates[i]);
                backtrack(candidates, i, target - candidates[i], path, result); // Recur with updated target
                path.remove(path.size() - 1); // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}

/**
 * Problem 6: Sudoku Solver
 * Given a 9x9 Sudoku board filled with digits and empty spaces ('.'),
 * fill the board so that every row, column, and 3x3 grid contains
 * numbers 1-9 exactly once. Uses backtracking to explore possibilities.
 */
public class SudokuSolver {
    public static boolean solveSudoku(char[][] board) {
        return solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') { // Find an empty cell
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) { // Check if it's valid
                            board[i][j] = num;
                            if (solve(board)) return true; // Recursively solve rest of board
                            board[i][j] = '.'; // Backtrack if no solution
                        }
                    }
                    return false; // If no number fits, return false
                }
            }
        }
        return true; // All cells are filled correctly
    }

    private static boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num ||
                board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == num) {
                return false; // Check row, column, and 3x3 grid
            }
        }
        return true;
    }
}


