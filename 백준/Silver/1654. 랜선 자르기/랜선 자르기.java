// 최대 랜선의 길이
// 선을 다 더해서 N으로 나누기
// 그 값으로 실행. 개수가 안맞으면 다시

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
		int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

		int[] arr = new int[K];

		long max = 0;

		// 입력과 동시에 해당 랜선의 길이가 최댓값인지를 확인하고 max를 갱신
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i])
				max = arr[i];
		}
		
		// max+1 해야 상한선을 이용할 수 있다.
		max++;
		
		long min = 0;
		long mid = 0;
		
		// 이분탐색
		while(min < max) {
			// 범위 내에서 중간 길이를 구한다.
			mid = (max + min) / 2;
			
			long cnt = 0;
			
			for (int i =0 ; i < arr.length; i++) {
				cnt += (arr[i] / mid);
			}
			
			/*
			 *  [upper bound 형식]
			 *  
			 *  mid길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
			 *  자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
			 *  그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
			 */
			if (cnt < N) {
				max = mid;
			} else {
				min = mid + 1;
			}	
		} // 이분탐색 
		System.out.println(min - 1);
	} // main
}
