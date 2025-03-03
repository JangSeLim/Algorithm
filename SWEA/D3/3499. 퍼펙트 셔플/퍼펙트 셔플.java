import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            String[] cards = new String[N];
            for (int i = 0; i < N; i++) {
            	cards[i] = sc.next();
            }

            System.out.print("#" + test_case + " ");
            int mid = (N+1) / 2; // 왼쪽 
            for (int i = 0; i < mid; i++) {
            	System.out.print(cards[i] + " ");
            	if (i+mid < N) {
            		System.out.print(cards[i+mid] + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
