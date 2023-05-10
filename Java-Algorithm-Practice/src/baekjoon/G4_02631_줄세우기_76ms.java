package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_02631_줄세우기_76ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int k = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            for (int j = k; j > -1; j--) {
                if (dp[j] < cur)  {
                    dp[j + 1] = cur;
                    if (j == k) k++;
                    break;
                }
            }
        }
        System.out.println(N - k);
    }
}