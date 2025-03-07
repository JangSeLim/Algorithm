import java.util.Scanner;

class Solution {
	static int H;
	static int W;
	static char[][] map;
	static int r;
	static int c;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt(); // 높이
			W = sc.nextInt(); // 너비

			// 현재위치
			r = -1;
			c = -1;

			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String str = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					// 현재위치 저장
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						r = i;
						c = j;
					}
				}
			} // 2차원 배열 map

			int N = sc.nextInt(); // 명령 개수
			char[] command = sc.next().toCharArray(); // 명령어 배열

//			// 출력 확인 (디버깅)
//			System.out.println("#" + tc + " ");
//			for (int i = 0; i < H; i++) {
//				for (int j = 0; j < W; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println(Arrays.toString(command));
//			System.out.println(r + " " + c);
//
            for (char cmd : command) {
                execute(cmd);
//                // 출력 확인
//                for (int i = 0; i < H; i++) {
//                    System.out.println(new String(map[i]));
//                }
//                System.out.println("명령어 " + cmd);
//                System.out.println();
            }
            
			// 출력 확인
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		} // 테스트케이스

	} // main

	// U, D, L, R
	static void execute(char cmd) {
		int nr = r;
		int nc = c;

		if (cmd == 'U') {
			map[r][c] = '^';
			nr = r - 1;
		} else if (cmd == 'D') {
			map[r][c] = 'v';
			nr = r + 1;
		} else if (cmd == 'L') {
			map[r][c] = '<';
			nc = c - 1;
		} else if (cmd == 'R') {
			map[r][c] = '>';
			nc = c + 1;
		}

		if (cmd == 'U' || cmd == 'D' || cmd == 'L' || cmd == 'R') {
			if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == '.') {
				map[nr][nc] = map[r][c];
				map[r][c] = '.';
				r = nr;
				c = nc;
			}
		}

		if (cmd == 'S') {
			shoot();
		}
	}

	// shoot 함수
	static void shoot() {
		int sr = r;
		int sc = c;
		int dr = 0;
		int dc = 0;

		if (map[r][c] == '^')
			dr = -1;
		if (map[r][c] == 'v')
			dr = 1;
		if (map[r][c] == '<')
			dc = -1;
		if (map[r][c] == '>')
			dc = 1;

		while (true) {
			sr += dr;
			sc += dc;

			if (sr < 0 || sr >= H || sc < 0 || sc >= W)
				break;
			if (map[sr][sc] == '#')
				break;
			if (map[sr][sc] == '*') {
				map[sr][sc] = '.';
				break;
			}
		}

	}

}
// 
