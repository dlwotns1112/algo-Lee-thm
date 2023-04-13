package ssafy.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11052_카드구매하기_S1_이재순_108ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < i; j++) {
				if (P[i]<P[j]+P[i-j-1]) {
					P[i] = P[j]+P[i-j-1];
				}
			}
		}
		System.out.println(P[N-1]);
	}
}
