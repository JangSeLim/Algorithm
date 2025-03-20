class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while (!canFit(wallet, bill)) { // 지폐가 들어가지 않으면 계속 접음
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        
        return answer;
    }
    
    // 지폐가 그대로 또는 회전해서 들어갈 수 있는지 확인하는 메서드
    private boolean canFit(int[] wallet, int[] bill) {
        return (bill[0] <= wallet[0] && bill[1] <= wallet[1]) || 
               (bill[1] <= wallet[0] && bill[0] <= wallet[1]);
    }
}
