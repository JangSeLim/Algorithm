import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
                
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
        	int N = sc.nextInt();
        	Stack<Integer> stack  = new Stack<>();
        	int sum = 0;
        	for (int n = 0; n < N; n++) {
        		int money = sc.nextInt();
        		if (money == 0) {
        			stack.pop();
        			continue;
        		}
        		stack.push(money);
        	}
        	while (stack.size()>0) {
        		sum+= stack.pop();
        	}
           
            
            System.out.println("#" + test_case + " " + sum);

        }
    }
}