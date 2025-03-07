import java.util.*;

public class Matrix_Chain_Multiplication {
    public static int mcm(int arr[], int i, int j) {
        if (i == j) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm(arr, i, k);
            int cost2 = mcm(arr, k + 1, j);

            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalcost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalcost);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5}; // Choose the correct array values
        int n = arr.length;
        System.out.println(mcm(arr, 1, n - 1));
    }
}