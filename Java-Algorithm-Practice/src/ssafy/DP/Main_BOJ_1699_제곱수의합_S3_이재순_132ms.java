package ssafy.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1699_제곱수의합_S3_이재순_132ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			dp[i] = i; 
			for (int j = 1, max = (int)Math.pow(i, 0.5); j <= max; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		System.out.println(dp[N]);
	}
}
