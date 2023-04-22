package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_16562_친구비168ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] pay = new int[N + 1];
        int[] friends = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pay[i] = Integer.parseInt(st.nextToken());
            friends[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b, pay,  friends);
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (friends[i] == i) answer += pay[i];
            if (answer > k) {
                System.out.println("Oh no");
                return;
            }
        }
        System.out.println(answer);
    }
    public static void union(int a, int b, int[] pay, int[] friends) {
        int rootA = find(a, friends);
        int rootB = find(b, friends);
        if (rootA == rootB) return;
        if (pay[rootA] > pay[rootB]) friends[rootA] = rootB;
        else friends[rootB] = friends[rootA];
    }
    public static int find(int a, int[] friends) {
        if (friends[a] == a) return a;
        return friends[a] = find(friends[a], friends);
    }
}