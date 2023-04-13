package ssafy.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1520_내리막길_G4_이재순_312ms {
	private static int[][] memo;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력을 위한 리더 
        StringTokenizer st = new StringTokenizer(br.readLine()," ");//산의 세로크기와 가로크기를 입력받아 토큰화
        int M = Integer.parseInt(st.nextToken());//산의 세로 크기 1<=M<=500
        int N = Integer.parseInt(st.nextToken());//산의 가로 크기 1<=N<=500
        int[][] map = new int[M][N];//산의 높이정보를 담을 2차원 배열 
        for (int i = 0; i < M; i++) {//산의 세로 크기만큼 반복
            st = new StringTokenizer(br.readLine()," ");//산의 높이를 입력받아 토큰화
            for (int j = 0; j < N; j++) {//산의 가로 크기만큼 반복
                map[i][j] = Integer.parseInt(st.nextToken());//각지점의 높이 입력 1<=map[i][j]<=10000
            }
        }
        int[] dr = {-1, 0, 1, 0};//4방 탐색을 위한 row배열
        int[] dc = {0, 1, 0, -1};//4방 탐색을 위한 col배열

        ;//dfs진행
        memo = new int[M][N];
        for (int i = 0; i < M; i++) {
			Arrays.fill(memo[i], -1);
		}
		System.out.print(dfs(0, 0, map, dr, dc, M-1, N-1));//출력
	}//end of main
	private static int dfs(int r, int c, int[][] map, int[] dr, int[] dc, int M, int N) {
		if (memo[r][c] != -1) {
			return memo[r][c];
		}
		if (r==M&&c==N) {//제일 오른쪽 아래 지점에 도달했다면 진행
			return 1;//리턴
		}
		int cur = map[r][c];//현재 칸의 높이
		int cnt = 0;
		for (int i = 0; i < 4; i++) {//4방탐색
			int nr = r+dr[i];//탐색할 row값
			int nc = c+dc[i];//탐색할 col값
			if (nr>-1&&nr<=M&&nc>-1&&nc<=N&&map[nr][nc]<cur) {//nr과 nc가 배열의 인덱스를 벗어나지 않고 내리막길이라면 진행
				cnt += dfs(nr, nc, map, dr, dc, M, N);//dfs재귀
			}
		}
		return memo[r][c] = cnt;
	}//end of dfs
}//end of class
