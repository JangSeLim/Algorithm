import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
            	arr[i] = sc.nextInt();
            }
            
            int cnt = 0;
            int groupCnt = 1 << N;
            for(int k = 1; k < groupCnt; k++) {
            	int sum = 0;
            	
            	for (int i = 0; i <N; i++) {
            		if ((k & (1 << i)) != 0) {
            			sum += arr[i];
            		}
            	}
            	if (sum == K) {
            		cnt++;
            	}
            }
            
            System.out.println("#" + test_case + " " + cnt);
            
        }
        sc.close();
    
    }
}
