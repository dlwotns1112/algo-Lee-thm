package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S3_17212_달나라토끼를위한구매대금지불도우미_88ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+8];
        dp[1] = dp[2] = dp[5] = dp[7] = 1;
        int[] d = {1, 2, 5, 7};
        for (int i = 1; i <= N; i++) {
            int count = dp[i] + 1;
            for (int j = 0; j < 4; j++) {
                int temp = i + d[j];
                if (dp[temp] == 0 || count < dp[temp]) dp[temp] = count;
            }
        }
        System.out.println(dp[N]);
    }
}
