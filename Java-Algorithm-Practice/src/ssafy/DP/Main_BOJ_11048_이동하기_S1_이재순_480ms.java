package ssafy.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_11048_이동하기_S1_이재순_480ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N]; 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dr = {1, 0, 1};
        int[] dc = {0, 1, 1};

        ;
        int[][] memo = new int[M][N];
        for (int i = 0; i < M; i++) {
			Arrays.fill(memo[i], -1);
		}
		System.out.print(dfs(0, 0, map, dr, dc, M-1, N-1, memo));
	}
	private static int dfs(int r, int c, int[][] map, int[] dr, int[] dc, int M, int N, int[][] memo) {
		if (memo[r][c] != -1) {
			return memo[r][c];
		}
		if (r==M&&c==N) {
			return map[r][c];
		}
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if (nr<=M&&nc<=N) {
				cnt = Math.max(cnt, dfs(nr, nc, map, dr, dc, M, N, memo));
			}
		}
		
		return memo[r][c] = cnt+map[r][c];
	}
}
