import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long number = Long.parseLong(br.readLine());
        System.out.print(Long.toString(number, 2));
        br.close();
    }
}