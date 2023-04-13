package ssafy.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11055_가장큰증가부분수열_S2_이재순_100ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = dp[i] =Integer.parseInt(st.nextToken());
			for (int j = 0; j < i; j++) {
				if (arr[j]<arr[i]&&dp[j]+arr[i]>dp[i]) {
					dp[i] = arr[i]+dp[j];
				}
			}
			if (dp[i]>max) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
