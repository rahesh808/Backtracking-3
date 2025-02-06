import java.util.ArrayList;
import java.util.List;

/*
TC -> O(n!)
SC -> O(n*n)
*/

class Solution {
    boolean[][] mat;
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        mat = new boolean[n][n];
        result = new ArrayList<>();
        backTrack(0, n);
        return result;
    }

    private void backTrack(int row, int n) {

        // base
        if (row == n) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == true) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            result.add(ans);
            return;

        }

        // logic
        for (int i = 0; i < n; i++) {
            if (isValid(row, i, n)) {
                // action
                mat[row][i] = true;
                // recurse
                backTrack(row + 1, n);
                // backTrack
                mat[row][i] = false;
            }
        }
    }

    private boolean isValid(int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (mat[i][col]) {
                return false;
            }
        }
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (mat[i][j]) {
                return false;
            }
            i--;
            j--;
        }
        i = row;
        j = col;
        while (i >= 0 && j < n) {
            if (mat[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}