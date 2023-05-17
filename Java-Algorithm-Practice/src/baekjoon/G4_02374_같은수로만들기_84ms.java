package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_02374_같은수로만들기_84ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        Node prevNode = new Node(1000000001);
        for (int i = 0, prevNum = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == prevNum) continue;
            prevNode = new Node(tmp, prevNode);
            list.add(prevNode);
            prevNum = tmp;
        }
        new Node(1000000001, prevNode);

        Collections.sort(list);
        int size = list.size() - 1;
        long answer = 0;
        for (int i = 0; i < size; i++) {
            Node cur = list.get(i);
            if (cur.num == 0) continue;
            int nextNum;
            if (cur.left.num == cur.right.num) {
                if (cur.left.num == 1000000001) break;
                reLink(cur.left, cur.right.right);
                cur.right.num = 0;
                nextNum = cur.left.num;
            }
            else {
                reLink(cur.left, cur.right);
                nextNum = Math.min(cur.left.num, cur.right.num);
            }
            answer += nextNum - cur.num;
        }
        System.out.println(answer);
    }
    public static void reLink(Node left, Node right) {
        left.right = right;
        right.left = left;
    }
    public static class Node implements Comparable<Node>{
        int num;
        Node left;
        Node right;

        public Node(int num, Node left) {
            this.num = num;
            this.left = left;
            left.right = this;
        }
        public Node(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return num - o.num;
        }
    }
}