package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class G3_02143_두배열의합_528ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] A = new int[n][n];
        HashMap<Integer, Integer> subArr = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = i; j < n; j++) {
                A[i][j] = num;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                A[i - 1][j] += A[i][j];
                if (!subArr.containsKey(A[i][j])) {
                    subArr.put(A[i][j], 1);
                }
                else subArr.put(A[i][j], subArr.get(A[i][j]) + 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (!subArr.containsKey(A[0][j])) {
                subArr.put(A[0][j], 1);
            }
            else subArr.put(A[0][j], subArr.get(A[0][j]) + 1);
        }

        long answer = 0;
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[][] B = new int[m][m];
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = i; j < m; j++) {
                B[i][j] = num;
            }
        }
        for (int i = m - 1; i > 0; i--) {
            for (int j = m - 1; j >= i; j--) {
                B[i - 1][j] += B[i][j];
                if (subArr.containsKey(T - B[i][j])) {
                    answer += subArr.get(T - B[i][j]);
                }
            }
        }
        for (int j = 0; j < m; j++) {
            if (subArr.containsKey(T - B[0][j])) {
                answer += subArr.get(T - B[0][j]);
            }
        }

        System.out.println(answer);
    }
}
