import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Solution {

    static int N, W, H;
    static int[][] map;
    static int result; 

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 구슬의 개수
            W = Integer.parseInt(st.nextToken()); // 가로
            H = Integer.parseInt(st.nextToken()); // 세로
            map = new int[H][W];
            
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = Integer.MAX_VALUE;
            // 구슬을 쏘는 모든 경우를 시도
            dfs(0, map);

            System.out.println("#" + tc + " " + result);
        }
    }

    // 구슬을 쏘고 결과를 계산하는 DFS
    static void dfs(int count, int[][] map) {
        if (count == N) {  // 구슬을 다 쏘았으면, 남은 벽돌 수를 계산
            result = Math.min(result, getRemainingBrickCount(map));
            return;
        }

        // 각 열에 대해 구슬을 쏘는 경우
        for (int i = 0; i < W; i++) {
            int[][] newMap = cloneMap(map);
            shootBall(newMap, i);  // i번째 열에 구슬을 쏜다
            dropBricks(newMap);  // 벽돌을 떨어뜨린다
            dfs(count + 1, newMap);  // 재귀적으로 구슬을 쏜다
        }
    }

    // 벽돌 상태를 복사하여 새로운 배열을 반환
    static int[][] cloneMap(int[][] map) {
        int[][] newMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }

    // 구슬이 명중한 열에서 벽돌을 제거하는 함수
    static void shootBall(int[][] map, int col) {
        for (int row = 0; row < H; row++) {
            if (map[row][col] != 0) {  // 벽돌이 있으면
                dfsBreak(map, row, col);  // 해당 벽돌을 터뜨린다
                break;
            }
        }
    }

    // 벽돌을 터뜨리고, 연쇄적으로 폭발하는 DFS
    static void dfsBreak(int[][] map, int row, int col) {
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(row, col));

        while (!stack.isEmpty()) {
            Point p = stack.pop();
            int r = p.r;
            int c = p.c;
            int power = map[r][c];
            map[r][c] = 0;  // 벽돌 제거

            // 상하좌우로 power - 1만큼 폭발
            for (int d = 0; d < 4; d++) {
                for (int i = 1; i < power; i++) {
                    int nr = r + dr[d] * i;
                    int nc = c + dc[d] * i;

                    if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
                        stack.push(new Point(nr, nc));  // 연쇄 폭발을 위해 stack에 추가
                    }
                }
            }
        }
    }

    // 벽돌이 내려오는 과정
    static void dropBricks(int[][] map) {
        for (int c = 0; c < W; c++) {
            Stack<Integer> stack = new Stack<>();
            // 해당 열의 벽돌을 모은다
            for (int r = 0; r < H; r++) {
                if (map[r][c] != 0) {
                    stack.push(map[r][c]);
                }
            }
            // 벽돌을 아래로 채운다
            for (int r = H - 1; r >= 0; r--) {
                if (!stack.isEmpty()) {
                    map[r][c] = stack.pop();
                } else {
                    map[r][c] = 0;
                }
            }
        }
    }

    // 남아있는 벽돌의 개수를 계산
    static int getRemainingBrickCount(int[][] map) {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
