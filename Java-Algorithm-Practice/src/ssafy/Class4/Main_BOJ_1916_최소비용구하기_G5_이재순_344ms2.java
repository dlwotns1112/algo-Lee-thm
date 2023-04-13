package ssafy.Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1916_최소비용구하기_G5_이재순_344ms2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine())+1;
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Node[] nodes = new Node[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			nodes[from] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), nodes[from]);
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq= new PriorityQueue<Node>();
		int[] distance = new int[N];
		distance[start] = -1;
		for (Node cur = nodes[start]; cur!=null; cur = cur.next) {
			pq.offer(cur);
		}
		int test= 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (distance[cur.to]!=0) {
				continue;
			}
			distance[cur.to] = cur.weight;
			if (cur.to==end) break;
			for (Node curNode = nodes[cur.to]; curNode!=null ; curNode = curNode.next) {
				if (distance[curNode.to]==0) {
					test++;
					pq.offer(new Node(curNode.to, cur.weight + curNode.weight, null));
				}
			}
		}
		System.out.println(test);
		System.out.println(distance[end]);
		
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
			return this.weight - o.weight;
		}
	}
}

