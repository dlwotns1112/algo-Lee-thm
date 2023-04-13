package ssafy.Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_17144_미세먼지안녕_G4_이재순_404ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int cleaner = 0;
		
		int ans = 0; 
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					cleaner = i;
				}
				else ans+= map[i][j];
			}
		}
		while (T-->0) {
			diffusion(map, R, C);
			ans -= clean(map, R, C, cleaner);
		}
		System.out.println(ans);
	}
	private static void diffusion(int[][] map, int R, int C) {
		int[][] add = new int[R][C];
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j]>4) {
					int size = 0;
					for (int k = 0; k < 4; k++) {
						int nr = i+dr[k];
						int nc = j+dc[k];
						if (nr>-1&&nr<R&&nc>-1&&nc<C&&map[nr][nc]!=-1) {
							size++;
						}
					}
					for (int k = 0; k < 4; k++) {
						int nr = i+dr[k];
						int nc = j+dc[k];
						if (nr>-1&&nr<R&&nc>-1&&nc<C&&map[nr][nc]!=-1) {
							add[nr][nc] += map[i][j]/5;
						}
					}
					map[i][j]-=(map[i][j]/5)*size;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] +=add[i][j];
			}
		}
	}
	private static int clean(int[][] map, int R, int C, int cleaner) {
		int cleaned = map[cleaner+1][0]+map[cleaner-2][0];
		for (int i = cleaner-3; i > -1; i--) {
			map[i+1][0] = map[i][0];
		}
		for (int i = cleaner+2; i < R; i++) {
			map[i-1][0] = map[i][0];
		}
		for (int i = 1, r = R-1; i < C; i++) {
			map[0][i-1] = map[0][i];
			map[r][i-1] = map[r][i];
		}
		for (int i = 1, c = C-1; i < cleaner; i++) {
			map[i-1][c] = map[i][c];
		}
		for (int i = R-2, c = C-1; i >= cleaner; i--) {
			map[i+1][c] = map[i][c];
		}
		for (int i = C-2, temp = cleaner - 1; i > 0; i--) {
			map[temp][i+1] = map[temp][i];
			map[cleaner][i+1] = map[cleaner][i];
		}
		map[cleaner][1] = map[cleaner-1][1] = 0;
		return cleaned;
	}
}
