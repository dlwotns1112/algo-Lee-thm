package ssafy.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1309_동물원_S1_이재순_84ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 3;
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i-1]*2 + dp[i-2])%9901;
		}
		System.out.println(dp[N]);
		
	}
}
