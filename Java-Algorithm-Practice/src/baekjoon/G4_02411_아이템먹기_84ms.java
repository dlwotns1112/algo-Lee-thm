package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_02411_아이템먹기_84ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[A + 2];
        nodes[0] = new Node(1, 1);
        nodes[A + 1] = new Node(N, M);
        for (int i = 1; i <= A; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(nodes);
        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], 1);
            map[i][0] = 0;
        }
        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 0;
        }
        int answer = 1;
        for (int i = 0; i <= A; i++) {
            Node from = nodes[i];
            Node to = nodes[i + 1];
            for (int c = from.y + 1; c <= to.y; c++) {
                if (map[from.x][c] == 0)
                    while (c++ < to.y) map[from.x][c] = 0;
            }
            for (int r = from.x + 1; r <= to.x; r++) {
                if (map[r][from.y] == 0)
                    while (r++ < to.x) map[r][from.y] = 0;
            }
            for (int r = from.x + 1; r <= to.x ; r++) {
                for (int c = from.y + 1; c <= to.y; c++) {
                    if (map[r][c] != 0)
                        map[r][c] = map[r - 1][c] + map[r][c - 1];
                }
            }
            answer *= map[to.x][to.y];
        }
        System.out.println(answer);
    }
    static class Node implements Comparable<Node>{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return x + y - o.y - o.x;
        }
    }
}