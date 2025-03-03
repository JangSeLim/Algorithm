import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
                
        int T = sc.nextInt();
        sc.nextLine();
        for (int test_case = 1; test_case <= T; test_case++) {
        	String str = sc.nextLine();
        	int N = str.length();
        	int sum = 0;
        	Stack<Character> stack  = new Stack<>();
        	for (int i = 0; i < N;i++) {
        		char c = str.charAt(i);
        		if (c == '(') {
        			stack.push(c);
        		} else { //  ) 라면 
        			if (str.charAt(i-1) == '(') { // 레이저 -> (하나빼고 남은 (개수 더하기 
        				stack.pop();
        				sum += stack.size();
        			} else { // 조각하나 끝. - 더하기 1
        				stack.pop();
        				sum += 1;
        			}
        		}
        	}
           
            
            System.out.println("#" + test_case + " " + sum);

        }
    }
}