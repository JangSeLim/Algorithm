import java.util.*;

public class Solution {
    static class Edge implements Comparable<Edge> {
        int to;
        long cost;

        Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt(); // 테스트 케이스 개수 입력
        
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 섬의 수
            int[] x = new int[N];
            int[] y = new int[N];
            
            for (int i = 0; i < N; i++) {
                x[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                y[i] = sc.nextInt();
            }
            double e = sc.nextDouble();
            
            // 인접 리스트 생성
            List<Edge>[] graph = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    long dist = (long) (x[i] - x[j]) * (x[i] - x[j]) + 
                                (long) (y[i] - y[j]) * (y[i] - y[j]);
                    graph[i].add(new Edge(j, dist));
                    graph[j].add(new Edge(i, dist));
                }
            }
            
            // 프림 알고리즘 (우선순위 큐 활용)
            boolean[] visited = new boolean[N];
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(0, 0)); // 임의의 시작점
            long answer = 0;
            int count = 0;
            
            while (!pq.isEmpty() && count < N) {
                Edge current = pq.poll();
                if (visited[current.to]) continue;
                
                visited[current.to] = true;
                answer += current.cost;
                count++;
                
                for (Edge next : graph[current.to]) {
                    if (!visited[next.to]) {
                        pq.add(next);
                    }
                }
            }
            
            sb.append("#").append(tc).append(" ").append(Math.round(answer * e)).append("\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
