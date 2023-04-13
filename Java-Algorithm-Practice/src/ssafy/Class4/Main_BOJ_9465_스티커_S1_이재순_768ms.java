package ssafy.Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_9465_스티커_S1_이재순_768ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) 
				sticker[0][i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			sticker[1][0] = Integer.parseInt(st.nextToken());
			
			if (n>1) {
				sticker[0][1]+=sticker[1][0];
				sticker[1][1]=Integer.parseInt(st.nextToken())+sticker[0][0];
				for (int i = 2; i < n; i++) {
					sticker[1][i] = Integer.parseInt(st.nextToken())+Math.max(sticker[0][i-1], sticker[0][i-2]);
					sticker[0][i] += Math.max(sticker[1][i-1], sticker[1][i-2]);
				}
			}
			sb.append(Math.max(sticker[0][n-1], sticker[1][n-1])).append("\n");
		}
		System.out.print(sb);
	}
}
