import java.util.Scanner;
 
public class Solution {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
                
        for (int test_case = 1; test_case <= 10; test_case++) {
        	int T = sc.nextInt();
        	char[][] arr = new char[100][100];
        	for (int i = 0; i < 100; i++) {
        		String line = sc.next();
        		for (int j = 0; j< line.length(); j++) {
        			arr[i][j] = line.charAt(j);
        		}
         	}
            
            int maxLength = 0;
        	for (int i = 0; i< 100; i++) {
        		StringBuilder row = new StringBuilder();
        		StringBuilder col = new StringBuilder();
        		for (int j = 0; j < 100 ; j++) {
        			row.append(arr[i][j]);
        			col.append(arr[j][i]);
        		}
        		
        		maxLength = Math.max(maxLength, findPalindrome(row.toString()));
        		maxLength = Math.max(maxLength, findPalindrome(col.toString()));

        	}
        	
        	
            
            System.out.println("#" + T + " " + maxLength);

        }
    }
    
    static int expandCenter(String str, int left, int right) {
    	while (left >= 0 && right < str.length()&& str.charAt(left) == str.charAt(right)) {
    		left--;
    		right++;
    	}
    	return right-left-1;
    }
    
    static int findPalindrome(String str) {
    	int maxLength = 0;
    	for (int i = 0; i < str.length();i++) {
    		int oddLength = expandCenter(str, i, i);
    		maxLength = Math.max(maxLength, oddLength);
    		
    		int evenLength = expandCenter(str, i, i+1);
    		maxLength = Math.max(maxLength, evenLength);
    	}
    	return maxLength;
    }
}