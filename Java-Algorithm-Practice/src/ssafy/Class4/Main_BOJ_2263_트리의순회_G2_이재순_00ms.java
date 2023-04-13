package ssafy.Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_BOJ_2263_트리의순회_G2_이재순_00ms {
	private static int N, temp, root;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] inorder = new int[N];
		for (int i = 0; i < N; i++) inorder[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] postorder = new int[N];
		for (int i = 0; i < N; i++) postorder[i] = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		Node[] nodes = new Node[N+1];
		for (int i = 0; i <= N; i++) {
			nodes[i] = new Node(i);
		}
		makePreorder(inorder, postorder, st, 0, 0, 0, nodes);
		preorder(nodes, root == 0 ? nodes[0].right.idx:root, sb);
		System.out.println(sb);
	}
	private static void preorder(Node[] nodes, int cur, StringBuilder sb) {
		sb.append(cur).append(" ");
		if (nodes[cur].left!=null) preorder(nodes, nodes[cur].left.idx, sb);
		if (nodes[cur].right!=null) preorder(nodes, nodes[cur].right.idx, sb);
	}
	private static int[] makePreorder(int[] inorder, int[] postorder, StringTokenizer st,int start1, int start2, int cur, Node[] nodes) {
		for (int i = start1, j = start2; i < N; i++, j++) {
			if (inorder[i]==postorder[j]&&i!=N-1) {
				nodes[inorder[i+1]].left = nodes[postorder[j]];
				root = inorder[i+1];
			}
			else if (postorder[j] == cur) {
				nodes[cur].right = nodes[inorder[i-1]];
				root = cur;
				return new int[] {i,j};
			}
			else if (i==N-1) {
				nodes[cur].right = nodes[inorder[i]];
				root = cur;
				return new int[] {i,j};
			}
			else {
				int[] result = makePreorder(inorder, postorder, st, i+1, j, inorder[i], nodes);
				if (result[0]==N-1) {
					nodes[cur].right = nodes[inorder[i]];
					root = cur;
					break;
				}
				else if (result[0]==N) break;
				else {
					nodes[inorder[result[0]]].left = nodes[inorder[i]];
					root = inorder[result[0]];
				}
				i = result[0]-1;
				j = result[1];
			}
		}
		return new int[] {N, N};
	}
	static class Node {
		int idx;
		Node left, right;
		public Node(int idx) {
			this.idx = idx;
		}
	}
}
