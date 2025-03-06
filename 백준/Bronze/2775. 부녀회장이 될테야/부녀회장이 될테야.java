import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int k = sc.nextInt(); // k층
            int n = sc.nextInt(); // n호
            
            int[] people = new int[n];
            for (int j = 0; j < n; j++) {
                people[j] = j + 1; // 0층 초기화
            }
            
            for (int x = 0; x < k; x++) {
                for (int y = 1; y < n; y++) {
                    people[y] += people[y - 1];
                }
            }
            
            System.out.println(people[n - 1]);
        }
        
        sc.close();
    }
}
