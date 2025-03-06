import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        System.out.println(toBinary(N));
    }

    static String toBinary(long n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
        	sb.append(n % 2);
        	n /= 2;
        }
        return sb.reverse().toString();
    }
}
