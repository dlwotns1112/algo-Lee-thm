package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G3_01301_비즈공예_196ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] beads = new int[5];
        for (int i = 0; i < n; i++) {
            beads[i] = Integer.parseInt(br.readLine());
        }
        long[][][][][][][] dp = new long[beads[0] + 1][beads[1] + 1][beads[2] + 1][beads[3] + 1][beads[4] + 1][6][6];
        System.out.println(go(dp, 5, 5, beads[0], beads[1], beads[2], beads[3], beads[4]));
    }
    static long go(long[][][][][][][] dp, int prev, int prev2, int a, int b, int c, int d, int e) {
        if (a + b + c + d + e == 0) return 1;
        if (dp[a][b][c][d][e][prev][prev2] != 0) return Math.max(dp[a][b][c][d][e][prev][prev2], 0);
        long ret = 0;
        if (a != 0 && prev != 0 && prev2 != 0) {
            ret += go(dp, 0, prev, a - 1, b, c, d, e);
        }
        if (b != 0 && prev != 1 && prev2 != 1) {
            ret += go(dp, 1, prev, a, b - 1, c, d, e);
        }
        if (c != 0 && prev != 2 && prev2 != 2) {
            ret += go(dp, 2, prev, a, b, c - 1, d, e);
        }
        if (d != 0 && prev != 3 && prev2 != 3) {
            ret += go(dp, 3, prev, a, b, c, d - 1, e);
        }
        if (e != 0 && prev != 4 && prev2 != 4) {
            ret += go(dp, 4, prev, a, b, c, d, e - 1);
        }
        if (ret == 0) {
            ret--;
            dp[a][b][c][d][e][prev][prev2] = ret;
            return 0;
        }
        return dp[a][b][c][d][e][prev][prev2] = ret;
    }
}
