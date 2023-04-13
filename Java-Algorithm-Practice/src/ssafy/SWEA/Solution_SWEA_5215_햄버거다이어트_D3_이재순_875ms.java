package ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_햄버거다이어트_D3_이재순_875ms {
	static int score;
	static int kcal;
	static int maxScore;
	static int[][] arr;
	static int N, L;
	static boolean[] inc;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 0; testcase < T; testcase++) {
			score = 0;
			kcal = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			inc = new boolean[N];
			arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			maxScore = Integer.MIN_VALUE;
			makeBurger(0);
			sb.append("#").append(testcase+1).append(" ").append(maxScore).append("\n");
		}
		System.out.println(sb);
	}//end of main
	private static void makeBurger(int n) {
		if (N == n) {
			for (int i = 0; i < N; i++) {
				if (inc[i]) {
					score += arr[i][0];
					kcal += arr[i][1];
				}
			}
			if (kcal<=L&&score>maxScore) {
				maxScore = score;
			}
			score = 0;
			kcal = 0;
			return;
		}
		inc[n] = false;
		makeBurger(n+1);
		inc[n] = true;
		makeBurger(n+1);
	}
}//end of class
