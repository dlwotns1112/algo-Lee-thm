package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_05972_택배배송_336ms {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] distance = new int[N + 1];
        Arrays.fill(distance, 50000000);
        distance[1] = 0;
        Node[] nodes = new Node[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes[a] = new Node(b, weight, nodes[a]);
            nodes[b] = new Node(a, weight, nodes[b]);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0, null));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.to == N) break;
            if (distance[cur.to] < cur.weight) continue;

            for (Node curNode = nodes[cur.to]; curNode != null ; curNode = curNode.next) {
                if (distance[curNode.to] > cur.weight + curNode.weight) {
                    distance[curNode.to] = cur.weight + curNode.weight;
                    pq.offer(new Node(curNode.to, distance[curNode.to], null));
                }
            }
        }
        System.out.println(distance[N]);
    }
    static class Node implements Comparable<Node> {
        int to, weight;
        Node next;

        public Node(int to, int weight, Node next) {
            this.to = to;
            this.weight = weight;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
