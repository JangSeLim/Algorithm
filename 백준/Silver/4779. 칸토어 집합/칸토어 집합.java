import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] K = new String[13];  // 0부터 12까지의 인덱스를 사용할 예정
        K[0] = "-";

        // K 배열을 채우기
        for (int i = 1; i <= 12; i++) {
            K[i] = K[i - 1] + " ".repeat(K[i - 1].length()) + K[i - 1];
        }

        // 입력을 받아서 출력하는 반복문
        while (sc.hasNext()) {
            try {
                int index = sc.nextInt();
                System.out.println(K[index]);
            } catch (Exception e) {
                break;
            }
        }

        sc.close();
    }
}
