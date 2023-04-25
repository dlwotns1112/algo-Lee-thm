package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_17396_백도어_972ms {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] possible = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (st.nextToken().charAt(0) == '0') possible[i] = true;
            else possible[i] = false;
        }
        possible[N - 1] = true;
        Node[] nodes = new Node[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if (possible[a] && possible[b]) {
                nodes[a] = new Node(b, t, nodes[a]);
                nodes[b] = new Node(a, t, nodes[b]);
            }
        }
        long[] distance = new long[N--];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[N] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(N, 0, null));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (distance[cur.to] < cur.weight) continue;
            if (cur.to == 0) break;
            for (Node curNode = nodes[cur.to]; curNode != null ; curNode = curNode.next) {
                if (distance[curNode.to] > cur.weight + curNode.weight) {
                    distance[curNode.to] = cur.weight + curNode.weight;
                    pq.offer(new Node(curNode.to, distance[curNode.to], null));
                }
            }
        }
        if (distance[0] == Long.MAX_VALUE) distance[0] = -1;
        System.out.println(distance[0]);
    }
    static class Node implements Comparable<Node>{
        int to;
        long weight;
        Node next;

        public Node(int to, long weight, Node next) {
            this.to = to;
            this.weight = weight;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight < 0 ? -1 : 1;
        }
    }
}
