import java.io.FileInputStream;
import java.util.Scanner;
 
public class Solution {
    
    //                0: 우, 1: 하, 2: 좌, 3: 상 
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    
    public static void main(String[] args) throws Exception{
    	//System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            
            int N = sc.nextInt();
            int[][] board = new int[N][N];
            
            int row = 0;
            int col = 0;
            int num = 1;
            int d = 0;
            
            while (num <= N * N) {
                board[row][col] = num++;
                
                int nr = row + dr[d]; 
                int nc = col + dc[d];
                
                // 배열 범위를 벗어나거나
                // 이미 숫자가 적힌 칸에 가게되면
                // 방향을 꺾는다
                if (!(0 <= nr && nr < N && 0 <= nc && nc < N) || board[nr][nc] > 0) {
                    d = (d + 1) % 4;
                    nr = row + dr[d]; 
                    nc = col + dc[d];
                }
                
                row = nr;
                col = nc;
            }

            System.out.println("#" + test_case);
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    System.out.print(board[r][c] + " ");
                }
                System.out.println();
            }
        }
    }
}