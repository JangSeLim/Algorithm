import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    static int N = 1000000; // 백만개의 정수
    static int[] arr = new int[N];

    public static void main(String args[]) throws Exception {
        // 입력 받는 방식 최적화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력받기
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // k번째 값 찾기 (500000번째 값 찾기)
        int result = quickSelect(0, N - 1, 500000);

        System.out.println(result);
    }

    static int quickSelect(int start, int end, int k) {
        while (start <= end) {
            int pivot = lomutoPart(start, end);

            // k번째 값이 pivot에 해당하면 그 값을 반환
            if (pivot == k) {
                return arr[pivot];
            }

            // k번째 값이 pivot보다 왼쪽에 있으면 왼쪽 부분을 재귀 호출
            else if (pivot > k) {
                end = pivot - 1; // 재귀 대신 반복문으로 바꾸기
            }

            // k번째 값이 pivot보다 오른쪽에 있으면 오른쪽 부분을 재귀 호출
            else {
                start = pivot + 1; // 재귀 대신 반복문으로 바꾸기
            }
        }
        return -1;
    }

    static int lomutoPart(int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = tmp;

        return i + 1;
    }
}
