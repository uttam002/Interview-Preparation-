class Solution {
    static long jumpingNums(long X) {
        long maxJumping = 0;
        Queue<Long> queue = new LinkedList<>();
        for (long i = 1; i <= 9; i++) queue.offer(i);
        while (!queue.isEmpty()) {
            long num = queue.poll();
            if (num > X) continue;
            maxJumping = Math.max(maxJumping, num);
            long lastDigit = num % 10;
            if (lastDigit > 0) queue.offer(num * 10 + lastDigit - 1);
            if (lastDigit < 9) queue.offer(num * 10 + lastDigit + 1);
        }
        return maxJumping;
    }
}
