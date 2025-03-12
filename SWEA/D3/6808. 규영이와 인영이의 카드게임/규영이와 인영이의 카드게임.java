import java.util.Scanner;

class Solution {
    static int N;
    static int[] kyoung;
    static int[] cards; // 남은 카드 목록
    static int win;
    static int lose;
    static int[] iyoung;
    static boolean[] visited;
    

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
        	N = 9;
        	kyoung = new int[N];
        	for (int i = 0; i < N; i++) {
        		kyoung[i] = sc.nextInt();
        	}
        	
        	boolean[] exist = new boolean[19];
        	for (int i = 0; i < N; i++) {
        		exist[kyoung[i]] = true;
        	}
        	
        	int idx = 0;
        	cards = new int[N];
        	for (int i = 1; i <= 18; i++) {
        		if (!exist[i]) {
        			cards[idx++] = i;
        		}
        	}
        	
        	
        	win = 0;
        	lose = 0;
        	visited = new boolean[N];
        	iyoung = new int[N];
        	perm(0);
        	
        	System.out.println("#" + tc + " " + win + " " + lose);
        }
        
    }
    
    static void perm(int level) {
    	if (level == N) {
    		round();
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {
    		if (visited[i]) continue;
    		
    		visited[i] = true;
    		iyoung[level] = cards[i];
    		perm(level + 1);
    		visited[i] = false;
    		
    	}
    }
    
    static void round() {
    	int kScore = 0;
    	int iScore = 0;
    	
    	for (int i = 0; i < N; i++) {
    		if (kyoung[i] > iyoung[i]) {
    			kScore += (kyoung[i] + iyoung[i]);
    		} else if (kyoung[i] < iyoung[i]) {
    			iScore += (kyoung[i] + iyoung[i]);
    		}
    	}
    	
    	if (kScore > iScore) {
    		win++;
    	} else if (kScore < iScore){
    		lose++;
    	}
    }
}
