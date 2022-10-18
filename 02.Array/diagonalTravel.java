import java.util.*;

class diagonalTravel {

    // GAP strategy
    static ArrayList<Integer> downwardDigonal(int n, int A[][]) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j >= 0; i++, j--) {
                ans.add(A[i][j]);
            }
        }

        for (int gap = 1; gap < n; gap++) {
            for (int i = gap, j = n - 1; i < n; i++, j--) {
                ans.add(A[i][j]);
            }
        }

        return ans;
    }
}