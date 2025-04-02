import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static HashSet<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine()); // 연산의 수
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int x = 0;
			if (st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());
			
			if (command.equals("add")) add(x);
			else if(command.equals("remove")) remove(x);
			else if (command.equals("check")) sb.append(check(x)).append("\n");
			else if(command.equals("toggle")) toggle(x);
			else if (command.equals("all")) all();
			else if (command.equals("empty")) empty();
			
		}
		
		System.out.println(sb);
	} // main
	
	static void add(int x) {
		set.add(x);
	}
	
	static void remove(int x) {
		set.remove(x);
	}
	
	static int check(int x) {
		if (set.contains(x)) return 1;
		else return 0;
	}
	
	static void toggle(int x) {
		if (set.contains(x)) set.remove(x);
		else set.add(x);
	}
	
	static void all() {
		set.clear();
		for (int i = 1; i <= 20; i++) {
			set.add(i);
		}
	}
	
	static void empty() {
		set.clear();
	}
}
