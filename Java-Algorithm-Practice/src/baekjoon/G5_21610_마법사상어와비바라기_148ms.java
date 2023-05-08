package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_21610_마법사상어와비바라기_148ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] drFinal = {0, 0, -1, -1, -1, 0, 1, 1, 1};
        int[] dcFinal = {0, -1, -1, 0, 1, 1, 1, 0, -1};
        int[] ddrFinal = {-1, -1, 1, 1};
        int[] ddcFinal = {-1, 1, 1, -1};
        Node cloud = new Node(N - 1, 0, new Node(N - 1, 1, new Node(N - 2, 0, new Node(N - 2, 1, null))));
        while (M-- > 0) {
            boolean[][] check = new boolean[N][N];
            st = new StringTokenizer(br.readLine());
            Node rain = null;
            int temp = Integer.parseInt(st.nextToken());
            int dr = drFinal[temp];
            int dc = dcFinal[temp];
            temp = Integer.parseInt(st.nextToken());
            for (Node cur = cloud; cur != null ; cur = cur.next) {
                int nr = Math.floorMod(cur.r + dr * temp, N);
                int nc = Math.floorMod(cur.c + dc * temp, N);
                map[nr][nc]++;
                rain = new Node(nr, nc, rain);
                check[nr][nc] = true;
            }
            for (Node cur = rain; cur != null ; cur = cur.next) {
                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + ddrFinal[i];
                    int nc = cur.c + ddcFinal[i];
                    if (nr > -1 && nr < N && nc > -1 && nc < N && map[nr][nc] > 0) {
                        map[cur.r][cur.c]++;
                    }
                }
            }
            cloud = null;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > 1 && !check[i][j]) {
                        cloud = new Node(i, j, cloud);
                        map[i][j] -= 2;
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += map[i][j];
            }
        }
        System.out.println(answer);
    }
    static class Node {
        int r, c;
        Node next;

        public Node(int r, int c, Node next) {
            this.r = r;
            this.c = c;
            this.next = next;
        }
    }
}
