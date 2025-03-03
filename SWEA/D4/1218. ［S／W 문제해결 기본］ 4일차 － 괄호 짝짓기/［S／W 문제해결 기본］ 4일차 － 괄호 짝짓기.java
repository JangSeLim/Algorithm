import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
                
        for (int test_case = 1; test_case <= 10; test_case++) {
        	int N = sc.nextInt();
        	String str = sc.next();
        	
        	boolean isValid = true;
        	Stack<Character> stack  = new Stack<>();
        	int answer = 0;
        	
        	for (int i = 0; i < N; i++) {
        		char c = str.charAt(i);
        		if (c == '(' || c == '[' || c == '<' || c == '{') {
        			stack.push(c);
        		} else {
        			if (stack.isEmpty()) {
        				isValid = false;
        				break;
        			}
        			
        			char last = stack.pop();
        			if ((c == ')' && last != '(') || (c == ']' && last != '[') || (c == '}' && last != '{') || (c == '>' && last != '<')) {
        				isValid = false;
        				break;
        			}
        		}
        	}
        	
        	if (isValid && stack.isEmpty()) {
        		answer = 1;
        	}
           
            
            System.out.println("#" + test_case + " " + answer);

        }
    }
}