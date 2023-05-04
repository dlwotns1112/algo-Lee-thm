package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_04179_불_448ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        Queue<int[]> q = new LinkedList<>();
        int Jr = 0, Jc = 0;
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                switch (line.charAt(j)) {
                    case '#':
                        map[i][j] = 3000;
                        break;
                    case '.':
                        map[i][j] = -9999;
                        break;
                    case 'J':
                        map[i][j] = -9999;
                        Jr = i;
                        Jc = j;
                        break;
                    case 'F':
                        q.add(new int[]{i, j});
                        break;
                }
            }
        }
        int t = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        while (!q.isEmpty()) {
            t--;
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = cur[0] + dr[i];
                    int nc = cur[1] + dc[i];
                    if (nr > -1 && nr < R && nc > -1 && nc < C && t > map[nr][nc]) {
                        map[nr][nc] = t;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
        }
        q.add(new int[] {Jr, Jc});
        map[Jr][Jc] = 0;
        t = 0;
        while (!q.isEmpty()) {
            t--;
            int size = q.size();
            try {
                while (size-- > 0) {
                    int[] cur = q.poll();
                    for (int i = 0; i < 4; i++) {
                        int nr = cur[0] + dr[i];
                        int nc = cur[1] + dc[i];
                        if (map[nr][nc] < t) {
                            map[nr][nc] = 0;
                            q.add(new int[] {nr, nc});
                        }
                    }
                }
            }
            catch (Exception e) {
                System.out.println(t * -1);
                return;
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
