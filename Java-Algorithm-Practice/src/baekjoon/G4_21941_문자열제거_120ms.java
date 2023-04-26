package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_21941_문자열제거_120ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int size = S.length();
        int M = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i + 1, 1, nodes[i]);
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String target = st.nextToken();
            int targetSize = target.length();
            int weight = Integer.parseInt(st.nextToken());
            if (targetSize < weight) {
                for (int j = 0; j < size; j++) {
                    int idx = S.indexOf(target, j);
                    if (idx == -1 ) break;
                    j = idx;
                    nodes[idx] = new Node(idx + targetSize, weight, nodes[idx]);
                }
            }
        }
        int[] dp = new int[size + 1];
        for (int i = 0; i < size; i++) {
            for (Node cur = nodes[i]; cur != null ; cur = cur.next) {
                if (dp[cur.to] > dp[i] + cur.weight) continue;
                dp[cur.to] = dp[i] + cur.weight;
            }
        }
        System.out.println(dp[size]);
    }
    static class Node {
        int to, weight;
        Node next;

        public Node(int to, int weight, Node next) {
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
    }
}