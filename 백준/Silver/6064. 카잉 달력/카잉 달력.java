
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N, x, y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 개수
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			System.out.println(ing());
		}

		
	} // main

	static int ing() {
		int max = M * N;
		int year = x;
		
		while (year <= max) {
			// 1-based indexing을 고려해야.
			if ((year - 1) % N + 1 == y) {
				return year;
			}
			year += M;	
		}
		return -1;
	}
	
}
