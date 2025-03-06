
// 병합 정렬
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] A;
	static int[] B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");		
		N = Integer.parseInt(nm[0]); // 배열 A의 크기
		M = Integer.parseInt(nm[1]); // 배열 B의 크기
		
		String[] aInput = br.readLine().split(" ");
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(aInput[i]);
		}
		
		String[] bInput = br.readLine().split(" ");
		B = new int[M];
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(bInput[i]);
		}
		
		int[] mergeArr = merge(A, B);
		
		StringBuilder sb = new StringBuilder();
		for (int n : mergeArr) {
			sb.append(n).append(" ");
		}
		System.out.println(sb.toString());
	}

	static int[] merge(int[] A, int[] B) {

		int[] mergedArray = new int[N + M];

		int i = 0, j = 0, k = 0;
		while (i < N && j < M) {
			if (A[i] <= B[j]) {
				mergedArray[k++] = A[i++];
			} else {
				mergedArray[k++] = B[j++];
			}
		}

		// 배열 A가 남은 경우
		while (i < N) {
			mergedArray[k++] = A[i++];
		}

		// 배열 B가 남은 경우
		while (j < M) { // 수정된 부분: i 대신 j로 수정
			mergedArray[k++] = B[j++];
		}

		return mergedArray;
	}
}
