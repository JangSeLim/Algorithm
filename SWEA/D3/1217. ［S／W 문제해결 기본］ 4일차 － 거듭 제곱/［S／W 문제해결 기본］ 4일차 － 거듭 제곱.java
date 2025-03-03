import java.util.Scanner;
 
public class Solution {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
                
        for (int test_case = 1; test_case <= 10; test_case++) {
        	int tc = sc.nextInt();        	
        	int N = sc.nextInt();
        	int M = sc.nextInt();

           
            
            System.out.println("#" + tc + " " + power(N,M));

        }
    }
    static int power(int N, int M) {
    	if (M == 1) {
    		return N;
    	}
    	
    	return N * power(N, M-1);
    }
}