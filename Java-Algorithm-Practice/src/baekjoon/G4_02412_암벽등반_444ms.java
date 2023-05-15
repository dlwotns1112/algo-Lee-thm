package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_02412_암벽등반_444ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(nodes);
        int[] idx = new int[T + 2];
        for (int i = 0, k = 0; i < n; i++) {
            for (; k <= nodes[i].y; k++) {
                idx[k] = i;
            }
        }
        idx[T + 1] = n;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        int answer = 0;
        while (!q.isEmpty()) {
            answer++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                int xMin = cur.x - 2;
                int xMax = cur.x + 2;
                int yMin = cur.y - 2;
                int yMax = cur.y + 2;
                for (int j = yMin < 0 ? idx[0] : idx[yMin]; j < n; j++) {
                    if (nodes[j] == null) continue;
                    if (nodes[j].y > yMax) break;
                    if (nodes[j].x < xMin) continue;
                    if (nodes[j].x > xMax) {
                        j = idx[nodes[j].y + 1] - 1;
                        continue;
                    }
                    if (nodes[j].y == T) {
                        System.out.println(answer);
                        return;
                    }
                    q.add(nodes[j]);
                    nodes[j] = null;
                }
            }
        }
        System.out.println(-1);
    }
    static class Node implements Comparable<Node>{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (y == o.y) return x - o.x;
            return y - o.y;
        }
    }
}