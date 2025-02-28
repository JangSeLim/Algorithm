import java.util.Scanner;
 
public class Solution {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
                
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.next();
        
            System.out.println("#" + test_case+ " " + reverse(str));
//            System.out.println("#" + test_case + " " + stringBuilder(str));
//            System.out.println("#" + test_case + " " + swap(str));

        }
    }
    
    static int reverse(String str) {
    	int N = str.length();
    	char[] arrChar = new char[N];
    	for (int i = 0; i < N; i++) {
    		arrChar[i] = str.charAt(N-1-i);
    	}
    	
    	if (String.valueOf(arrChar).equals(str)) {
    		return 1;
    	}
    	return 0;
    }
    
    static int stringBuilder(String str) {
    	StringBuilder sb = new StringBuilder(str);
    	sb.reverse();
    	if (sb.toString().equals(str)) {
    		return 1;
    	}
    	return 0;
    }
    
    static int swap(String str) {
    	int N = str.length();
    	char[] arrChar = str.toCharArray();
    	for (int i = 0; i < N/2; i++) {
    		char tmp = arrChar[i];
    		arrChar[i] = arrChar[N-1-i];
    		arrChar[N-1-i] = tmp;
    	}
    	if(String.valueOf(arrChar).equals(str)) {
    		return 1;
    	}
    	return 0;
    }
}