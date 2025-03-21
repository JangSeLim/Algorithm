class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        // 0의 개수 세기
        int zero = 0;
        for (int n: lottos) {
            if (n == 0) {
                zero++;
            }
        }
        
        // 일치하는 숫자의 개수 세기
        int got = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if  (lottos[i] == win_nums[j]) {
                    got++;
                    break;
                }
            }
        }
        System.out.println(zero + " " + got);

        int max = 7 - (zero + got);
        int min = 7 - got;
        if (max > 6) max = 6;
        if (min > 6) min = 6;

        System.out.println(max + " " + min);
        answer[0] = max;
        answer[1] = min;
        return answer;
    }
}