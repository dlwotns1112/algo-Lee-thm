package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class S4_10866_덱_136ms {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front" : {
                    q.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "push_back" : {
                    q.addLast(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop_front" : {
                    if (q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.pollFirst()).append("\n");
                    break;
                }
                case "pop_back" : {
                    if (q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.pollLast()).append("\n");
                    break;
                }
                case "size" : {
                    sb.append(q.size()).append("\n");
                    break;
                }
                case "empty" : {
                    sb.append(q.isEmpty()?1:0).append("\n");
                    break;
                }
                case "front" : {
                    if (q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.peekFirst()).append("\n");
                    break;
                }
                case "back" : {
                    if (q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.peekLast()).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
