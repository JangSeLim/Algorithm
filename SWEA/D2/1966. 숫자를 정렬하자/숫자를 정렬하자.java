import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i< N; i++) {
            	arr[i] = sc.nextInt();
            }            
            
            arrSort(arr);
            
            System.out.print("#" + test_case + " ");
            for (int n : arr) {
            	System.out.print(n + " ");
            }
            System.out.println();
            
        }
        sc.close();
    }
    // 삽입정렬 
    static void arrSort(int[] arr) {
    	for (int i = 1; i< arr.length; i++) {
    		int key = arr[i];
    		int j;
    		for (j = i-1; j >= 0 && key < arr[j]; j--) {
    			arr[j+1] = arr[j];
    		}
    		arr[j+1] = key;
    	}
    }
}
