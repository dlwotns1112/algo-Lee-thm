package ssafy.Class5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_17143_낚시왕_G2_이재순_356ms {
	private static int R;
	private static int C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][][] map = new int[R][C][3];//[][][0] = 속력   [][][1] = 방향   [][][2] = 크기
		
		for (int i = 0, r, c; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			map[r][c][0] = Integer.parseInt(st.nextToken());
			map[r][c][1] = Integer.parseInt(st.nextToken());
			map[r][c][2] = Integer.parseInt(st.nextToken());
			if (map[r][c][1]<3) 
				map[r][c][0]%=(R-1)*2;
			else 
				map[r][c][0]%=(C-1)*2;
		}
		
		int ans = 0;
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < map.length; i++) {
				if (map[i][j][2] != 0) {
					ans+=map[i][j][2];
					map[i][j][0] = map[i][j][1] = map[i][j][2] = 0;
					break;
				}
			}
			map = move(map);
		}
		
		System.out.println(ans);
		
	}
	private static int[][][] move(int[][][] map) {
		int[] dr = {0, -1, 1, 0, 0};
		int[] dc = {0, 0, 0, 1, -1};
		int[][][] result = new int[R][C][3];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				if (map[i][j][2] != 0) {
					int nr = dr[map[i][j][1]]*map[i][j][0]+i;
					int nc = dc[map[i][j][1]]*map[i][j][0]+j;
					for (int k = 0; k < 2; k++) {
						if (nr<0) {
							nr *= -1;
							map[i][j][1] = 2;
						}
						else if (nr>=R) {
							nr = (R-1)*2-nr;
							map[i][j][1] = 1;
						}
						else if (nc<0) {
							nc *= -1;
							map[i][j][1] = 3;
						}
						else if (nc>=C) {
							nc = (C-1)*2-nc;
							map[i][j][1] = 4;
						}
					}
					
					if (result[nr][nc][2] < map[i][j][2]) {
						result[nr][nc][0] = map[i][j][0];
						result[nr][nc][1] = map[i][j][1];
						result[nr][nc][2] = map[i][j][2];
					}
				}
			}
		}
		
		return result;
	}
}
