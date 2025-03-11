import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] res;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 줄 입력

		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		res = new int[M];

		// 새로운 StringTokenizer로 숫자 입력 받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 내림차순이 아니라 오름차순 정렬
		Arrays.sort(arr);

		comb(0, 0);
		System.out.println(sb);
	}

	public static void comb(int idx, int start) {
		if (idx == M) {
			for (int i : res)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			res[idx] = arr[i];
			comb(idx + 1, i + 1);
		}
	}
}
