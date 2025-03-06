import java.util.Scanner;

public class Main {
	
	static int[][] memo;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			memo = new int[k+1][n+1];

			int answer = number(k, n);
			System.out.println(answer);
		}
	}

	// a층 b호에 사는 사람들의 수를 구하는 함수
	static int number(int a, int b) {
		if (a == 0) return b;
		
		if (memo[a][b] != 0) {
			return memo[a][b];
		}
		
		int sum = 0;
		// a - 1층의 1호부터 b호까지 사는 사람들을 다 더해야함
		for (int i = 1; i <= b; i++) {
			sum += number(a - 1, i);
		}

		return memo[a][b] = sum;
	}
}