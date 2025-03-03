import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());
			}
			
			int minus = 1;
			
			while (true) {
				int first = queue.poll() - minus;
				if (first <= 0) {
					queue.offer(0);
					break;
				} else {
					queue.offer(first);
				}
				minus = (minus%5) + 1;
			}
			

			System.out.print("#" + T + " ");
			for (int num : queue) {
				System.out.print(num + " ");
			}
			System.out.println();

		}
		sc.close();
	}
}