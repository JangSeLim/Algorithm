import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static int H, W, r, c;
	static char[][] map;
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	static final char[] dirChar = { '^', 'v', '<', '>' };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] hw = br.readLine().split(" ");
			H = Integer.parseInt(hw[0]);
			W = Integer.parseInt(hw[1]);

			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					// 현재위치 저장
					if ("^v<>".contains(String.valueOf(map[i][j]))) {
						r = i;
						c = j;
					}
				}
			} // 2차원 배열 map

			int N = Integer.parseInt(br.readLine());
			char[] command = br.readLine().toCharArray(); // 명령어 배열

			for (char cmd : command) {
				execute(cmd);
			}

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");  // 각 행 뒤에 줄바꿈 추가
            }
            System.out.print(sb.toString());
			
//            // 출력 
//            System.out.print("#" + tc + " ");
//            for (int i = 0; i < H; i++) {
//                for (int j = 0; j < W; j++) {
//                    System.out.print(map[i][j]);
//                }
//                System.out.println(); // 각 행의 끝에 줄바꿈
//            }

		} // 테스트케이스

	} // main

	// U, D, L, R
	static void execute(char cmd) {
		int d = "UDLR".indexOf(cmd);
		if (d != -1) {
			map[r][c] = dirChar[d];
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (isInBound(nr, nc) && map[nr][nc] == '.') {
				map[nr][nc] = map[r][c];
				map[r][c] = '.';
				r = nr;
				c = nc;
			}
		} else if (cmd == 'S') {
			shoot();
		}
	}

	// shoot 함수
	static void shoot() {
		int d = "^v<>".indexOf(map[r][c]);
		int sr = r, sc = c;

		while (true) {
			sr += dr[d];
			sc += dc[d];

			if (!isInBound(sr, sc) || map[sr][sc] == '#') break;
			if (map[sr][sc]=='*') {
				map[sr][sc] = '.';
				break;
			}
		}
	}
	
	static boolean isInBound(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}
}