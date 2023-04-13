package ssafy.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2133_타일채우기_G5_이재순_96ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N%2 != 0) {
			System.out.println(0);
			return;
		}
		N/=2;
		int[] dp = new int[N+1];
		dp[0] = 1; dp[1] = 3;
		for (int i = 2; i <= N; i++) {
			dp[i] = 4*dp[i-1]-dp[i-2];
		}
		System.out.println(dp[N]);
	}
}
