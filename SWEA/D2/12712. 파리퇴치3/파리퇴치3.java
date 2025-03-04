import java.util.Scanner;

class Solution {

    // 상하좌우
    static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    // 대각선
    static int[][] diag = { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
            		// +
            		int sum1 = arr[i][j];
            		for (int k = 0; k < 4; k++) {
            			int nr = i;
            			int nc = j;
            			for (int m = 0; m < M-1; m++) {
            				nr += delta[k][0];
            				nc += delta[k][1];
            				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            					sum1 += arr[nr][nc];
            				}
            			}
            		}
            		
            		max = Math.max(max, sum1);
            		
            		// x
            		int sum2 = arr[i][j];
            		for (int k = 0; k < 4; k++) {
            			int nr = i;
            			int nc = j;
            			for (int m = 0; m < M-1; m++) {
            				nr += diag[k][0];
            				nc += diag[k][1];
            				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            					sum2 += arr[nr][nc];
            				}
            			}
            		}
            		
            		max = Math.max(max, sum2);
            	}
            }
            
            

            System.out.println("#" + tc + " " + max);  // 결과 출력
        }
    }
}
