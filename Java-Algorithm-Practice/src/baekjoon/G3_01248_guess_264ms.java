package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G3_01248_guess_264ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] matrix = new char[n + 1][n + 1];
        String line = br.readLine();
        for (int i = 1, k = 0; i <= n; i++) {
            for (int j = i; j <= n; j++, k++) {
                matrix[i][j] = line.charAt(k);
            }
        }
        int[][] sum = new int[n + 1][n + 1];
        int[] answer = new int[n + 1];
        go(answer, sum, n, 1, matrix);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
    static boolean go(int[] answer, int[][] sum, int n, int r, char[][] matrix) {
        if (n < r) {
            return true;
        }
label:  for (int cur = -10; cur < 11; cur++) {
            for (int i = 1; i <= r; i++) {
                sum[i][r] = sum[i][r - 1] + cur;
                switch (matrix[i][r]) {
                    case '+' :
                        if (sum[i][r] <= 0) {
                            continue label;
                        }
                        break;
                    case '-' :
                        if (sum[i][r] >= 0) {
                            continue label;
                        }
                        break;
                    case '0' :
                        if (sum[i][r] != 0) {
                            continue label;
                        }
                        break;
                }
            }
            answer[r] = cur;
            if (go(answer, sum, n, r + 1, matrix)) return true;
        }
        return false;
    }
}
