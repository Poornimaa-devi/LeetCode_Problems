    // Traverse from the second row and second column
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            // Check if the current element is equal to the element in the previous diagonal
            if (matrix[i][j] != matrix[i - 1][j - 1]) {
                return false;
            }
        }
    }
    return true;   // If all diagonals are valid, return true
}