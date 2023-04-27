package baekjoon;

import java.io.*;

public class S3_01003_피보나치함수_76ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[42];
        dp[0] = 1;
        dp[1] = 0;
        for (int i = 2; i < 42; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append(" ").append(dp[N+1]).append("\n");
        }
        System.out.println(sb);
    }
}
