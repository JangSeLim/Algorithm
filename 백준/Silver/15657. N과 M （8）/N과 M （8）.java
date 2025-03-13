import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static int[] visited;
	static StringBuilder sb = new StringBuilder(); // 시간초과 해결용

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		for (int i = 0 ; i< N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		result = new int[M];
		perm(0, 0);
		System.out.println(sb);
	}
	
	static void perm(int level, int start) {
		if (level == M) {
			for (int k = 0; k < M; k++) {
				sb.append(result[k] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			// 이전 값과 동일한 값이 있을 경우 건너뛰기
			if (i > start && arr[i] == arr[i-1]) continue;
			
			result[level] = arr[i];
			perm(level + 1, i);
		}
		
	}

}
