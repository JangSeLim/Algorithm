import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, dir, r, c;
    static int[][] map;

    // 방향 배열: 상(0), 우(1), 하(2), 좌(3)
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            int startR = 0, startC = 0;

            // 맵 정보 입력
            for (int i = 0; i < N; i++) {
                String[] row = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    switch (row[j]) {
                        case "G": map[i][j] = 0; break;      // 땅: 이동 가능
                        case "T": map[i][j] = -1; break;     // 나무: 이동 불가
                        case "X":                           // 시작 위치
                            map[i][j] = 0;
                            startR = i;
                            startC = j;
                            break;
                        case "Y": map[i][j] = 1; break;      // 도착 지점
                    }
                }
            }

            int Q = Integer.parseInt(br.readLine()); // 조종 명령 횟수

            while (Q-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int C = Integer.parseInt(st.nextToken());
                char[] commands = st.nextToken().toCharArray();

                // 로봇의 초기 위치 및 방향 설정
                r = startR;
                c = startC;
                dir = 0; // 시작 방향: 위

                // 명령 실행
                for (char cmd : commands) {
                    if (cmd == 'A') {
                        moveForward();
                    } else if (cmd == 'L') {
                        dir = (dir + 3) % 4; // 좌회전
                    } else if (cmd == 'R') {
                        dir = (dir + 1) % 4; // 우회전
                    }
                }

                // 도착 여부 판단
                sb.append(map[r][c] == 1 ? 1 : 0).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    // 앞으로 이동: 나무(-1)나 범위를 벗어나면 이동하지 않음
    static void moveForward() {
        int nr = r + dr[dir];
        int nc = c + dc[dir];

        if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != -1) {
            r = nr;
            c = nc;
        }
    }
}
