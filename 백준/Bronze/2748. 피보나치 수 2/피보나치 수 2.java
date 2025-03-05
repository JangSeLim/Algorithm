import java.util.Scanner;

public class Main {

	static long[] arr;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new long[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = -1;
		}

		arr[0] = 0;
		arr[1] = 1;

		System.out.println(fibo(n));
	}

	static long fibo(int n) {
		if (arr[n] != -1) {
			return arr[n];
		}

		arr[n] = fibo(n - 1) + fibo(n - 2);

		return arr[n];
	}
}