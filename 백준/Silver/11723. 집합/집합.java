import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> set = new HashSet<>();
		int M = Integer.parseInt(br.readLine()); // 연산의 수
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int x = 0;
			if (st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());
			
			switch (command) {
			case "add":
				set.add(x);
				break;
			case "remove":
				set.remove(x);
				break;
			case "check":
				if (set.contains(x))
					sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "toggle":
				if (set.contains(x)) set.remove(x);
				else set.add(x);
				break;
			case "all":
				set.clear();
				for(int n = 1; n <= 20; n++) set.add(n);
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		
		System.out.println(sb);
	} // main
}
