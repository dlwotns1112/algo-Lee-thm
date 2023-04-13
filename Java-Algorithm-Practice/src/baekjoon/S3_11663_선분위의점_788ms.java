package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_11663_선분위의점_788ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(points);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start > points[N-1] || end < points[0]) {
                sb.append(0).append("\n");
                continue;
            }
            if (start <= points[0]) start = 0;
            else start = findPoint(0, N-1, points, start, 1);
            if (end >= points[N-1]) end = N-1;
            else end = findPoint(0, N-1, points, end, 0);
            sb.append(end - start + 1).append("\n");
        }
        System.out.println(sb);
    }
    public static int findPoint(int start, int end, int[] points, int target, int side){
        int mid = (start + end) / 2;
        if (mid == start) {
            return start + side;
        }
        if (points[mid] == target) {
            return mid;
        }
        else if (points[mid] > target) {
            return findPoint(start, mid, points, target, side);
        }
        else return findPoint(mid, end, points, target, side);
    }
}
