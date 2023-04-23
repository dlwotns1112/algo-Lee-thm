package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class S3_17212_달나라토끼를위한구매대금지불도우미_116ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(0);
            return;
        }
        boolean[] map = new boolean[N+8];
        int[] d = {1, 2, 5, 7};
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        int answer = 0;
        while (true){
            int size = q.size();
            answer++;
            while (size-- > 0) {
                int cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int temp = cur + d[i];
                    if (temp == N) {
                        System.out.println(answer);
                        return;
                    }
                    if (!map[temp]) {
                        q.add(temp);
                        map[temp] = true;
                    }
                }
            }
        }
    }
}
