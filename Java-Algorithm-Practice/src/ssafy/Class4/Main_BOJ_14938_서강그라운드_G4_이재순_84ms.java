package ssafy.Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_14938_서강그라운드_G4_이재순_84ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] items = new int[n+1];
		st = new StringTokenizer(br.readLine());
		int[][] map = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(map[i], 3000);
		}
		
		for (int i = 0, a, b, dist; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			map[a][b] = dist;
			map[b][a] = dist;
		}
		
		for (int k = 1; k <=n; k++) {
			for (int i = 1; i <= n; i++) {
				if (map[i][k]==3000) {
					continue;
				}
				for (int j = 1; j <= n; j++) {
					if (map[k][j]==3000) {
						continue;
					}
					if (map[i][j]>map[i][k]+map[k][j]) {
						map[i][j] = map[i][k]+map[k][j];
					}
				}
			}
		}
		
		int ans = 0;
		for (int i = 1, temp; i <= n; i++) {
			temp = items[i];
			for (int j = 1; j <= n; j++) {
				if (map[i][j]<=m&&i!=j) {
					temp += items[j];
				}
			}
			if (temp>ans) {
				ans = temp;
			}
		}
		System.out.println(ans);
		
	}
}
