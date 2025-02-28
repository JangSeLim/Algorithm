import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();

			int[][] arr = new int[100][100];
			int x = 0;
			int y = 99;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
					if (i == 99 && arr[i][j] == 2) {
						x = j;
					}
				}
			}

			while (y != 0) {

				// 좌
				if (x - 1 >= 0 && arr[y][x - 1] == 1) {
					while (x - 1 >= 0 && arr[y][x - 1] == 1) {
						x--;
					}
				}

				// 우
				else if (x + 1 <= 99 && arr[y][x + 1] == 1) {
					while (x + 1 <= 99 && arr[y][x + 1] == 1) {
						x++;
					}
				}

				// 상
				y--;

				if (y == 0) {
					break;
				}
			}

			System.out.println("#" + T + " " + x);
		}
	}
}
// 뒤에서부터 올라가기