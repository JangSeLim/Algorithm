
class Solution {
    public int solution(String dartResult) {
        char[] dart = dartResult.toCharArray();
        int[] nums = new int[3];
        
        int idx = -1;
        for (int i = 0; i < dart.length; i++) {
            // 숫자인 경우
            if (dart[i] - '0' >= 0 && dart[i] - '0' <= 9) {
                // 10처리
                if (dart[i] == '1' && i+1 < dart.length && dart[i+1] == '0') {
                    nums[++idx] = 10;
                    i++;
                } else {
                    nums[++idx] = dart[i] - '0';
                }
            } else {
                if (dart[i] == 'D') {
                    nums[idx] = (int) Math.pow(nums[idx], 2);
                } else if (dart[i] == 'T') {
                    nums[idx] = (int) Math.pow(nums[idx], 3);
                } else if (dart[i] == '*') {
                    nums[idx] *= 2;
                    if ((idx-1) >= 0) {
                        nums[idx -1] *= 2;
                    }
                } else if (dart[i] == '#') {
                    nums[idx] *= -1;
                }
            }
        }
        int sum = 0;
            for (int n : nums) {
                sum += n;
            }

        return sum;
    }
}
