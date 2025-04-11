import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    
    // 현재 좌표(r, c), 부술 수 있는 남은 횟수(K), 현재까지 비용(cost), 방향(dir)을 저장하는 클래스
    static class Info {
        int r, c, K, cost, dir;

        public Info(int r, int c, int K, int cost, int dir) {
            this.r = r;
            this.c = c;
            this.K = K;
            this.cost = cost;
            this.dir = dir;
        }
    }

    // 방향: 상, 우, 하, 좌
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static int N, K;
    static int[][] map;
    static boolean[][][][] visited;
    static int startR, startC; // 시작 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N][K+1][4];
            
            for (int i = 0; i < N; i++) {
            	String line = br.readLine();
                for (int j = 0; j < N; j++) {
                	char ch = line.charAt(j);
                    switch (ch) {
                        case 'G': // 일반 칸
                            map[i][j] = 0;
                            break;
                        case 'T': // 장애물
                            map[i][j] = -1;
                            break;
                        case 'X': // 시작 지점
                            map[i][j] = 0;
                            startR = i;
                            startC = j;
                            break;
                        case 'Y': // 목표 지점
                            map[i][j] = 1;
                            break;
                    }
                }
            } // 입력 완료

            sb.append("#").append(t).append(" ").append(bfs()).append("\n");
        }

        System.out.println(sb.toString()); // 결과 출력
        br.close();
    }
    
    // BFS 탐색 시작
    static int bfs() {
    	Queue<Info> queue = new LinkedList<>();
    	visited[startR][startC][K][0] = true;
    	queue.add(new Info(startR, startC, K, 0, 0)); // 초기 상태
    	
    	while (!queue.isEmpty()) {
    		Info now = queue.poll();
    		int r = now.r, c = now.c, k = now.K, cost = now.cost, dir = now.dir;
    		
    		// 목적지 도달 시 종료
    		if (map[r][c] == 1) return cost;
    		
    		for (int i = 0; i < 4; i++) {
    			int nr = r + dr[i];
    			int nc = c + dc[i];
    			
    			// 1. 직진
    			if (dir == i) {
    				// 범위 벗어나면 패스
    				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
    				
    				// 장애물인 경우, 남은 부술 기회가 있다면
    				if (map[nr][nc] == -1) {
    					if (k > 0 && !visited[nr][nc][k - 1][i]) {
    						visited[nr][nc][k - 1][i] = true;
    						queue.add(new Info(nr, nc, k - 1, cost + 1, i));
    					}
    				}
    				// 빈 칸 또는 목적지
    				else {
    					if (!visited[nr][nc][k][i]) {
    						visited[nr][nc][k][i] = true;
    						queue.add(new Info(nr, nc, k, cost + 1, i));
    					}
    				}
    			}
    			
    			// 2. 오른쪽으로 90도 회전
    			if ((dir + 1) % 4 == i) {
    				if (!visited[r][c][k][i]) {
    					visited[r][c][k][i] = true;
    					queue.add(new Info(r, c, k, cost + 1, i));
    				}
    			}
    			
    			// 3. 왼쪽으로 90도 회전
    			int leftDir = (dir + 3) % 4;
    			if (leftDir == i) {
    				if (!visited[r][c][k][i]) {
    					visited[r][c][k][i] = true;
    					queue.add(new Info(r, c, k, cost + 1, i));
    				}
    			}
    		}
    	}
    	
    	return -1; // 목적지에 도달할 수 없는 경우
    }
}
