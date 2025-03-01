import java.util.Scanner;
 
public class Solution {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
                
        for (int test_case = 1; test_case <= 10; test_case++) {
        	int T = sc.nextInt();
        	sc.nextLine();
        	String p = sc.nextLine();
        	String text = sc.nextLine();
           
            
            System.out.println("#" + T + " " + searchPattern(text, p));

        }
    }
    static int searchPattern(String text, String p) {
    	int N = text.length();
    	int M = p.length();
    	int pLen;
    	int cnt=0;
    	
    	for (int i = 0; i < N - M+1; i++) {
    		pLen = 0;
    		for (int j = 0; j < M; j++) {
    			if (text.charAt(i+j) == p.charAt(j)) {
    				pLen++;
    			}
    		}
    		if (pLen == M) {
    			cnt++;
    		}
    	}
    	return cnt;
    }
}