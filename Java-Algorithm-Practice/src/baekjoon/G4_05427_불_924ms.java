package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_05427_불_924ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

label:  while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
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
                            map[i][j] = -1000000;
                            break;
                        case '@':
                            map[i][j] = -1000000;
                            Jr = i;
                            Jc = j;
                            break;
                        case '*':
                            q.add(new int[]{i, j});
                            break;
                    }
                }
            }
            int t = 0;
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
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
            q.add(new int[]{Jr, Jc});
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
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }
                } catch (Exception e) {
                    sb.append(t * -1).append("\n");
                    continue label;
                }
            }
            sb.append("IMPOSSIBLE\n");
        }
        System.out.println(sb);
    }
}
