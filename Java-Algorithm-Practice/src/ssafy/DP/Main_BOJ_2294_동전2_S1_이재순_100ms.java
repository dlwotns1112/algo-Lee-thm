package ssafy.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2294_동전2_S1_이재순_100ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k+1];
		Arrays.fill(dp, 10001);
		dp[0] = 0;
		int coin;
		for (int i = 0; i < n; i++) {
			coin = Integer.parseInt(br.readLine());
			for (int j = coin; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j-coin]+1);
			}
		}
		System.out.println(dp[k]==10001?-1:dp[k]);
	}
}
