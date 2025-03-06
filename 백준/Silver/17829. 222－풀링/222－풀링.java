import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] matrix;
    static int[][] nextPool;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 전역 변수 matrix 초기화
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 풀링 실행
        while (N > 1) {
            pooling(N);
        }

        // 결과 출력
        System.out.println(nextPool[0][0]);
    }

    // N/2로 나누는 풀링 함수
    static void pooling(int size) {
        int newSize = size / 2;
        nextPool = new int[newSize][newSize];

        for (int i = 0; i < size; i += 2) {
            for (int j = 0; j < size; j += 2) {
                // 2x2 부분 행렬
                int[] subMatrix = {
                    matrix[i][j], matrix[i][j + 1], 
                    matrix[i + 1][j], matrix[i + 1][j + 1]
                };

                // 두 번째로 큰 값 찾기
                Arrays.sort(subMatrix);
                nextPool[i / 2][j / 2] = subMatrix[2]; // 두 번째로 큰 값 저장
            }
        }

        // matrix를 nextPool로 업데이트
        matrix = nextPool;
        N = newSize; // 새로운 크기로 갱신
    }
}
