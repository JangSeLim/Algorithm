
import java.util.Scanner;

class Solution {
	
	static int[][] updown = {{-1, 0}, {1, 0}};
	static int[][] leftright = {{0, -1}, {0, 1}}; 
	
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						int row = i;
						int col = j;
						
						// 상하탐색
						int height = 1;
						for (int k = 0; k < 2; k++) {
							int nr = row;
							int nc = col;
							while (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 1) {
								nr += updown[k][0];
								nc += updown[k][1];
								if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 1) {
									height++;
								}
							}
						}
						
						// 좌우탐색
						int width = 1;
						for (int k = 0; k < 2; k++) {
							int nr = row;
							int nc = col;
							while (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 1) {
								nr += leftright[k][0];
								nc += leftright[k][1];
								if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 1) {
									width++;
								}
							}
						}
						int res = (height) * (width);
						answer = Math.max(answer, res);
					}
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
