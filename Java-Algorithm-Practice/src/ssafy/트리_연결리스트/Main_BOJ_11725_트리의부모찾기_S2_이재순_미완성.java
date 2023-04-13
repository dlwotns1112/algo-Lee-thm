package ssafy.트리_연결리스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_11725_트리의부모찾기_S2_이재순_미완성 {
	static int[] ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[N+1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node(i);
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (!nodes[b].hasparent()&&b!=1) {
				nodes[b].setParent(nodes[a]);
				nodes[a].addChild(nodes[b]);
			}
			else {
				nodes[a].setParent(nodes[b]);
				nodes[b].addChild(nodes[a]);
			}
		}
		ans = new int[N+1];
		findparents(nodes[1]);
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(ans[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void findparents(Node node) {
		ArrayList<Node> childs = node.getChilds();
		if (node.hasparent()) {
			ans[node.getIdx()] = node.getParent().getIdx();
		}
		int size = childs.size();
		for (int i = 0; i < size; i++) {
			findparents(childs.get(i));
		}
	}
}
class Node {
	private Node parent;
	private ArrayList<Node> childs;
	private int idx;
	public Node(int idx) {
		this.idx = idx;
		childs = new ArrayList<Node>();
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public void addChild(Node a) {
		childs.add(a);
	}
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public ArrayList<Node> getChilds() {
		return childs;
	}

	public void setChilds(ArrayList<Node> childs) {
		this.childs = childs;
	}
	public boolean hasparent() {
		return parent == null ? false : true;
	}
}
