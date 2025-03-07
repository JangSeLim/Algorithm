import java.util.Scanner;

class Solution {
	static int[] kyoung; // 규영이의 고정된 카드
	static int[] cards; // 인영이의 카드 팩
	static int[] iyoung; // 인영이의 고정된 카드(순열)
	static int N;
	static int win;
	static int lose;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			N = 9;
			kyoung = new int[N];
			cards = new int[N];
			iyoung = new int[N];
			
			for (int i = 0; i < N; i++) {
				kyoung[i] = sc.nextInt();
			} // 규영이의 고정된 카드
			
			boolean[] isExcluded = new boolean[19];
			for (int i = 0; i < N; i++) {
				isExcluded[kyoung[i]] = true;
			}
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!isExcluded[i]) {
					cards[idx++] = i;
				}
			} // 인영이 카드 팩

//			System.out.println(Arrays.toString(kyoung));
//			System.out.println(Arrays.toString(cards));
//			System.out.println();
			
			win = 0;
			lose = 0;
			perm(0);
			System.out.println("#" + tc + " " + win + " " + lose);

			
		} // 테스트케이스

	} // main
	
	// 인영이 카드팩 순열 구하는 함수
	static void perm(int idx) {
		if (idx == N) {
			round();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (iyoung[i] != 0) continue;
			
			iyoung[i] = cards[idx];
			perm(idx + 1);
			iyoung[i] = 0; 
			
		}
	}
	
	// 규영 카드 vs 인영 카드
	static void round() {
		int kwin = 0;
		int iwin = 0;

		for (int i = 0; i < N; i++) {
			if (kyoung[i] > iyoung[i]) {
				kwin += (kyoung[i] + iyoung[i]);
			} else if (kyoung[i] < iyoung[i]) {
				iwin += (kyoung[i] + iyoung[i]);
			}
		}
		
		if (kwin > iwin) {
			win++;
		} else if (kwin < iwin) {
			lose++;
		}
	}
	
}
// 1. 순열로 카드 배열 구하기
// 2. 카드 배열 나오면, 규영이와 각 라운드 비교하고 합산 구하기. 
