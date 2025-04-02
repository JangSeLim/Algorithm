// 돈을 인출하는데 필요한 시간 합의 최솟값

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
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
