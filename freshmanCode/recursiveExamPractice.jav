public static int minSteps(int[][] area, int row, int col) {
    if (row == 0 || col == 0 || row == area.length - 1 || col == area[0].length - 1) {
        return 0; // We are here!
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

private static boolean helper(Airline org, Airline dest, Set<Airline> visited) {
    if (org.equals(dest)) {
        return true; // Found a path.
    } else if (visited.contains(org)) {
        return false; // Already visited, avoid cycles.
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

public void update(int row, int col) {
    // Thinking ahead: row and col may be out of bounds.
    // Nothing to do in that case. Likewise, if this
    // cell is already revealed, nothing to do.
    // So, make sure it's in bounds and not already revealed.
    if (0 <= row && row < numMines.length 
        && 0 <= col && col < numMines[0].length 
        && !revealed[row][col]) {

        // Reveal the cell
        revealed[row][col] = true;

        if (numMines[row][col] == MINE) {
            gameOver = true; // Fixed the comparison: '==' to '='
        } else if (numMines[row][col] == 0) {
            // Oh my, need to reveal my neighbors.
            for (int r = row - 1; r <= row + 1; r++) {
                for (int c = col - 1; c <= col + 1; c++) {
                    update(r, c); // update handles out of bounds or already revealed.
                }
            }
        }
    }
}

