package ssafy.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_9663_NQueen_G5_이재순_00ms {
	
	private static int N, ans;
	private static int[] queens;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		queens = new int[N];
		ans = 0;
		bruteforce(0);
		System.out.println(ans);
	}
	
	private static void bruteforce(int row) {
		if (row == N) {
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if (queens[i]==queens[j]||(i+queens[i])==(j+queens[j])||(i-queens[i])==(j-queens[j])) {
						return;
					}
				}
			}
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			queens[row] = i;
			bruteforce(row+1);
		}
	}
}
