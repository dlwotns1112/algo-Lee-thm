package ssafy.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2225_합분해_G5_이재순_108ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[K][N+1];
		Arrays.fill(dp[0], 1);
		for (int i = 0; i <= N; i++) {
			for (int j = 1; j < K; j++) {
				for (int k = 0; k <= i; k++) {
					dp[j][i] +=dp[j-1][k];
					dp[j][i]%=1000000000;
				}
			}
		}
		System.out.println(dp[K-1][N]);
	}
}
