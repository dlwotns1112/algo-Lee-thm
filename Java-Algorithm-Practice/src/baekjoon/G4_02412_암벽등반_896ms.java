package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_02412_암벽등반_896ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] dr = {-2, -2, -2, -2, -2, -1, -1, -1, -1, -1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2};
        int[] dc = {-2, -1, 0, 1, 2, -2, -1, 0, 1, 2, -2, -1, 1, 2, -2, -1, 0, 1, 2, -2, -1, 0, 1, 2};
        HashSet<Node> set = new HashSet<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            set.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        int answer = 0;
        while (!q.isEmpty()) {
            answer++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                for (int j = 0; j < 24; j++) {
                    Node tmp = new Node(cur.x + dr[j], cur.y + dc[j]);
                    if (set.contains(tmp)) {
                        if (tmp.y == T) {
                            System.out.println(answer);
                            return;
                        }
                        q.add(tmp);
                        set.remove(tmp);
                    }
                }
            }
        }
        System.out.println(-1);
    }
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                Node tmp = (Node)obj;
                return x == tmp.x && y == tmp.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}