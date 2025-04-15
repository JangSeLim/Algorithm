import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int B = Integer.parseInt(st.nextToken()); // 인벤토리 블록 개수
		int[][] map = new int[N][M];
		int min = 256; // 최소 높이
		int max = 0; // 최대 높이
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (min > map[i][j]) min = map[i][j];
				if (max < map[i][j]) max = map[i][j];
			}
		}
		
		int time = Integer.MAX_VALUE; // 최소 시간 저장
		int high = 0;
		for (int h = min ; h <= max; h++) {
			int cnt = 0;
			int block = B;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					//현재 좌표의 층이 만들 층보다 높으면 제거하는데, 블록은 제거한 만큼 추가, 시간은 두배로
					if (h < map[i][j]) {
						cnt += ((map[i][j] - h) * 2);
						block += (map[i][j] - h);
					} 
					//낮을 경우 블록을 추가, 시간은 1배
					else {
						cnt += (h - map[i][j]);
						block -= (h - map[i][j]);
					}
					
				}
			}
			
			// 블록이 마이너스이면 반복문 종료 
			if (block < 0) break;
			
			// 최소 시간으로 갱신
			if (time >= cnt) {
				time = cnt;
				high = h;
			}
		}
		
		System.out.println(time + " " + high);
		
	} // main
}