import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    static class Tunnel {
        int v1, v2;
        long cost;

        Tunnel(int v1, int v2, long cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

    static long answer;
    static int[] p;
    static int[] x, y;
    static ArrayList<Tunnel> arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt(); // 테스트 케이스 개수 입력
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 섬의 수
            x = new int[N];
            for (int i = 0; i < N; i++) {
                x[i] = sc.nextInt();
            }
            y = new int[N];
            for (int i = 0; i < N; i++) {
                y[i] = sc.nextInt();
            }
            double e = sc.nextDouble();

            answer = 0;
            p = new int[N];
            for (int i = 0; i < N; i++) {
                p[i] = i;
            }

            arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {  // i == j 방지
                    long dist = (long) (x[i] - x[j]) * (x[i] - x[j]) + 
                                (long) (y[i] - y[j]) * (y[i] - y[j]);
                    arr.add(new Tunnel(i, j, dist));
                }
            }

            Collections.sort(arr, (o1, o2) -> Long.compare(o1.cost, o2.cost));

            int cnt = 0;
            for (Tunnel ob : arr) {
                int pa = findSet(ob.v1);
                int pb = findSet(ob.v2);
                if (pa != pb) {
                    answer += ob.cost;
                    union(ob.v1, ob.v2);
                    cnt++;
                    if (cnt == N - 1) break;
                }
            }

            sb.append("#").append(tc).append(" ").append(Math.round(answer * e)).append("\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }

    static int findSet(int v) {
        if (v != p[v]) p[v] = findSet(p[v]); // 경로 압축 적용
        return p[v];
    }

    static void union(int a, int b) {
        int pa = findSet(a);
        int pb = findSet(b);
        if (pa != pb) p[pa] = pb;
    }
}
