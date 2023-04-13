package ssafy.Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_17070_파이프옮기기1_G5_이재순_76ms {
	private static int[][][] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j*2);
			}
		}
		int[] dr = {1, 0, 1}; 
		int[] dc = {1, 1, 0}; 
		memo = new int[N][N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}
		System.out.println(dfs(0, 1, 1, map, N-1, dr, dc));
	}
	
	private static int dfs(int r, int c, int state, char[][] map, int N, int[] dr, int[] dc) {//state 0:대각,1:가로,2:세로
		if (r==N&&c==N) {
			return 1;
		}
		if (memo[r][c][state]!=-1) {
			return memo[r][c][state];
		}
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			if (i==state||i==0||state==0) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if (nr>-1&&nr<=N&&nc>-1&&nc<=N&&map[nr][nc]!='1') {
					if (i==0&&(map[r+1][c]=='1'||map[r][c+1]=='1')) {
						continue;
					}
					cnt+=dfs(nr, nc, i, map, N, dr, dc);
				}
			}
		}
		return memo[r][c][state] = cnt;
	}
}
