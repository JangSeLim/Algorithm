// 호어 파티션
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution {
 
    static int N = 1000000; // 백만개의 정수
    static int[] arr = new int[N];
 
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
 
        // 입력받기
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
 
        quickSort(0, N - 1);
         
        System.out.println(arr[500000]);
    }
 
    static void quickSort(int start, int end) {
        if (start < end) {
            int pivot = hoarePart(start, end);
            quickSort(start, pivot - 1);
            quickSort(pivot + 1, end);
        }
    }
 
    static int hoarePart(int start, int end) {
        int pivot = arr[start];
        int L = start+1;
        int R = end;
 
        while(L <= R) {
        	// L: 피벗보다 큰 값
        	while(L <= R && arr[L] <= pivot) L++;
        	
        	// R: 피벗보다 작거나 같은 값
        	while (arr[R] > pivot) R--;
        	
        	// 스왑
        	if (L < R) {
        		int tmp = arr[L];
        		arr[L] = arr[R];
        		arr[R] = tmp;
        	}
        }
        
        // R과 피벗 위치 교환
        int tmp = arr[start];
        arr[start] = arr[R];
        arr[R] = tmp;
        
        return R;
    }
 
}