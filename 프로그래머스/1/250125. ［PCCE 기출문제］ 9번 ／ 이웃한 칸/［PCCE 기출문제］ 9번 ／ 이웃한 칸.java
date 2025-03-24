class Solution {
    public int solution(String[][] board, int h, int w) {
        int N = board.length;
        int cnt = 0;
        
        // 상하좌우
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for (int i = 0; i < 4; i++) {
            int nr = h + dr[i];
            int nc = w + dc[i];
            
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (board[h][w].equals(board[nr][nc])) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}