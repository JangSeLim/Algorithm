// 돈을 인출하는데 필요한 시간 합의 최솟값

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람의 수
		int[] time = new int[N+1];
		for (int i = 1; i <= N; i++) {
			time[i] = sc.nextInt();
		}
		
		// 정렬
		Arrays.sort(time);
				
		// 누적합
		int res = 0;
		for (int i = 1; i <= N; i++) {
			time[i] += time[i-1];
			res += time[i];
		}
		System.out.println(res);
	}
}
