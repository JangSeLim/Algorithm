
// 4 <= N <= 20
// 1 <= dessert <= 100
// 시간복잡도: O(N^2 * 2^N)

// 최소 양 옆이 있어야 하고, 아래로는 2칸 여유가 있어야 사각형이 만들어짐
// 먹은 디저트를 방문처리, 위치도 방문처리
// dfs를 돌면서 이전의 방향 다음 방향만 탐색
// 자기자신에게 돌아온 경우(3번 이상 탐색) 종료시켜주고 max 갱신

import java.util.Scanner;

public class Solution {
    static int N, max;
    static int[][] map;
    static boolean[][] visited;
    static boolean[] dessert;

    static int[] dr = {1, 1, -1, -1}; // 우하, 좌하, 좌상, 우상
    static int[] dc = {1, -1, -1, 1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            N = sc.nextInt();
            map = new int[N][N];
            max = -1; // 기본값 -1 설정

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < N - 2; i++) { // 최소 2칸 필요
                for (int j = 1; j < N - 1; j++) { // 양옆 최소 한 칸 필요
                    visited = new boolean[N][N];
                    dessert = new boolean[101];
                    visited[i][j] = true;
                    dessert[map[i][j]] = true;
                    // 카페 수 / 이동 위치 i, j / 원점 i, j / 이전의 방향
                    dfs(1, i, j, i, j, 0);
                }
            }

            sb.append("#").append(tc).append(" ").append(max);
            System.out.println(sb.toString());
        }
        sc.close();
    }

    static void dfs(int cnt, int r, int c, int initR, int initC, int prevD) {
        for (int d = prevD; d < 4; d++) { 
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if ((nr == initR) && (nc == initC) && cnt > 3) { 
                    max = Math.max(max, cnt);
                    return;
                }

                if (!visited[nr][nc] && !dessert[map[nr][nc]]) {
                    visited[nr][nc] = true;
                    dessert[map[nr][nc]] = true;
                    dfs(cnt + 1, nr, nc, initR, initC, d);
                    visited[nr][nc] = false;
                    dessert[map[nr][nc]] = false;
                }
            }
        }
    }
}

