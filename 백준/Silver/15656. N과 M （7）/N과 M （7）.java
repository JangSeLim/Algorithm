import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder(); // 시간초과 해결용

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i< N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		result = new int[M];
		perm(0);
		System.out.println(sb);
	}
	
	static void perm(int level) {
		if (level == M) {
			for (int k = 0; k < M; k++) {
				sb.append(result[k] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			result[level] = arr[i];
			perm(level + 1);
		}
		
	}

}
// 중복순열 -> 순열에서 방문하는 것을 빼면 돼!
// scanner 시간초과 -> bufferedreader 시간초과 -> stringbuilder사용
