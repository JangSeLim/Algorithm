import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = Integer.MAX_VALUE;
		// 1. - 기준으로 나누기 (+ 먼저 처리)
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		while (st.hasMoreTokens()) {
			int tmp = 0;
			
			// 각 토큰을 더한다.
			StringTokenizer add = new StringTokenizer(st.nextToken(), "+");
			
			while (add.hasMoreTokens()) {
				tmp += Integer.parseInt(add.nextToken());
			}
			
			if (sum == Integer.MAX_VALUE) {
				sum = tmp;
			} else {
				sum -= tmp;
			}
		}
		System.out.println(sum);
	} // main
}
