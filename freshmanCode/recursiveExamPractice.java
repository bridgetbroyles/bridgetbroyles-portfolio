// 2024 Spring
// Problem: Recursively check if there is a path between two airlines by exploring their partners.
private static boolean helper(Airline org, Airline dest, Set<Airline> visited) {
    if (org.equals(dest)) {
        return true; 
    } else if (visited.contains(org)) {
        return false; 
    }

    // Mark the current airline as visited.
    visited.add(org);
    Airline[] partners = org.getPartners();

    for (int i = 0; i < partners.length; i++) {
        if (helper(partners[i], dest, visited)) {
            return true;
        }
    }

    return false;
}

//Fall 2023 Solves the problem of updating the game state when a cell is revealed. 
// Ensures that out-of-bounds cells or already revealed cells are not processed. 
// If a mine is revealed, the game ends. If a cell with zero adjacent mines is revealed, 
// its neighboring cells are recursively revealed.
public void update(int row, int col) {
    if (0 <= row && row < numMines.length
        && 0 <= col && col < numMines[0].length
        && !revealed[row][col]) {
        
        revealed[row][col] = true;

        if (numMines[row][col] == MINE) {
            gameOver = true; 
        } else if (numMines[row][col] == 0) {
            for (int r = row - 1; r <= row + 1; r++) {
                for (int c = col - 1; c <= col + 1; c++) {
                    update(r, c); // update handles out of bounds or already revealed.
                }
            }
        }
    }

// Spring 2023
// Problem: Find the minimum number of steps to reach the boundary of a 2D area,
// considering elevation differences between adjacent cells.
public static int minSteps(int[][] area, int row, int col) {
    if (row == 0 || col == 0 || row == area.length - 1 || col == area[0].length - 1) {
        return 0; 
    }
    int min = Integer.MAX_VALUE / 2;
    int thisElevation = area[row][col];
    area[row][col] = -100; // Mark as visited to avoid revisiting.

    for (int i = 0; i < rc_deltas[0].length; i++) {
        int newR = row + rc_deltas[0][i];
        int newC = col + rc_deltas[1][i];
        int diff = area[newR][newC] - thisElevation;
        if (-10 <= diff && diff <= 10) {
            int steps = 1 + minSteps(area, newR, newC);
            if (steps < min) {
                min = steps;
            }
        }
    }
    area[row][col] = thisElevation; // Undo visit for backtracking.
    return min;
}

// 2022 Spring
// Problem: Determine if a knight can reach a target position on a chessboard 
// within a given number of moves, considering valid knight moves.
public static boolean knightCanReach(int rows, Position knight, Position target, int numMoves) {
    // Base case: Knight is already at the target position
    if (knight.row == target.row && knight.col == target.col) {
        return true; // Got there!!! Pop, pop, pop!!!
    } else if (numMoves == 0) {
        return false; // Out of moves
    }

    numMoves--; // Local copy, okay to change

    // Explore all possible knight moves
    for (int[] deltas : KNIGHT_DIRECTIONS) {
        int newRow = knight.row + deltas[0];
        int newCol = knight.col + deltas[1];

        // Check if the new position is within bounds
        if (0 <= newRow && newRow < rows && 0 <= newCol && newCol < rows) {
            Position newPos = new Position(newRow, newCol);

            // Recursively check if the knight can reach the target from the new position
            if (knightCanReach(rows, newPos, target, numMoves)) {
                return true; 
            }
        }
    }

    return false; // Never found a solution
}

// 2021 Fall
// Problem: Recursively find all possible words by removing one letter at a time and checking against a dictionary.
public static void findWords(String word, Set<String> d, List<String> result) {
    if (word.length() > 0) {
        // Check if the word exists in the dictionary and is not already in the result
        if (d.contains(word) && !result.contains(word)) {
            result.add(word);
        }

        // Recursively try all possible reduced versions of the word
        for (int i = 0; i < word.length(); i++) {
            String reduced = word.substring(0, i) + word.substring(i + 1);
            findWords(reduced, d, result);
        }
    }
}

// Fall 2019
// Problem: Recursively check if there is a path between two buildings within a given number of links.
public static boolean pathExists(String start, String end, int links, BuildingMap map) {
    if (start.equals(end)) {
        return links == 0; // Found the end with no more links
    } else if (links > 0) {
        // Now visiting the 'start' building
        map.setVisited(start, true);
        int nextLinks = links - 1;
        String[] connections = map.connected(start);
        
        for (int i = 0; i < connections.length; i++) {
            String nextBuilding = connections[i];
            if (!map.visitedStatus(nextBuilding)) {
                boolean solved = pathExists(nextBuilding, end, nextLinks, map);
                if (solved) {
                    // Undo the change before returning
                    map.setVisited(start, false); // GACK
                    return true;
                }
            }
        }
        // Maybe there's another path through this building
        map.setVisited(start, false); // GACK
    }
    return false; // No path found
}
