//import java.io.FileInputStream;
import java.util.Scanner;
 
public class Solution {
    
    
    public static void main(String[] args) throws Exception {
//    	System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
                
        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = sc.nextInt();
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
            	for (int j = 0; j < 100; j++) {
            		arr[i][j] = sc.nextInt();
            	}
            }
            
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 100; i++) {
            	int rowSum = 0;
                int colSum = 0;
            	for (int j = 0; j < 100; j++) {
            		rowSum += arr[i][j];
            		colSum += arr[j][i];
            	}
            	max = Math.max(Math.max(rowSum, colSum), max);
            }
            
            int crossSum1 = 0;
            int crossSum2 = 0;
            for (int i = 0; i < 100; i++) {
            	crossSum1 += arr[i][i];
            	crossSum2 += arr[i][100-1-i];
            }
            max = Math.max(Math.max(crossSum1, crossSum2), max);
            
        
            System.out.println("#" + T + " " + max);
        }
    }
}