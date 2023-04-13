package ssafy.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2293_동전1_G5_이재순_84ms2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k];
		int coin;
		for (int i = 0; i < n; i++) {
			coin = Integer.parseInt(br.readLine());
			for (int j = coin*2; j < k; j++) {
				dp[j] += dp[j-coin]+1;
			}
		}
		System.out.println(dp[k-1]+1);
	}
}
