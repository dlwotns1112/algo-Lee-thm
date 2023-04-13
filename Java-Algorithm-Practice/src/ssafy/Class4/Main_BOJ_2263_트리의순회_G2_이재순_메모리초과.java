package ssafy.Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_BOJ_2263_트리의순회_G2_이재순_메모리초과 {
	private static int N, temp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] inorder = new int[N];
		for (int i = 0; i < N; i++) inorder[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		temp = Integer.parseInt(st.nextToken());
		Node[] nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node();
		}
		ArrayDeque<Integer> ans = new ArrayDeque<>(); 
		makePreorder(inorder, st, 0, 0, ans);
		while (!ans.isEmpty()) sb.append(ans.pollLast()).append(" ");
		System.out.println(sb);
		
	}
	private static int makePreorder(int[] inorder, StringTokenizer st,int start, int cur, ArrayDeque<Integer> preq) {
		ArrayDeque<Integer> q = new ArrayDeque<>(); 
		for (int i = start; i < N; i++) {
			if (inorder[i]==temp) {
				q.offer(temp);
				if (st.hasMoreTokens()) {
					temp = Integer.parseInt(st.nextToken());
				}
			}
			else if (temp == cur) {
				while (!q.isEmpty()) preq.offerFirst(q.pollLast());
				temp = Integer.parseInt(st.nextToken());
				return i-1;
			}
			else {
				q.offer(inorder[i]);
				i = makePreorder(inorder, st, i+1, inorder[i], q);
			}
		}
		while (!q.isEmpty()) preq.offerFirst(q.pollLast());
		return N;
	}
	static class Node {
		Node left, right;
	}
}
