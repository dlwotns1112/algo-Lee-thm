package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_01455_뒤집기2_84ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        int smallOne = Math.min(N, M);
        int answer = 0;
        for (int i = 0; i < smallOne; i++) {
            int row = --N;
            int col = --M;
            for (int r = row; r >= 0 ; r--) {
                if ( map[r][col] == 1) {
                    reverse(map, r, col);
                    answer++;
                }
            }
            for (int c = col - 1; c >= 0 ; c--) {
                if ( map[row][c] == 1) {
                    reverse(map, row, c);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void reverse(int[][] map, int r, int c) {
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                map[i][j] ^= 1;
            }
        }
    }
}
