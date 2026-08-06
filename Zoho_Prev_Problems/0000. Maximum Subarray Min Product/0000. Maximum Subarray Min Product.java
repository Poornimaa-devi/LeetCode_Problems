class Solution {
    // Presum will be helpful to get sum from i to j as presum[j] - presum[i] + nums[i];
    // Stack to get index in asending order 
    // While the number that is smaller then the stack.peek(), do stack.pop() as mid number
    // It will reguar current number is the next smaller. the new stack.peek() as previous smaller.
    // The total number will be (nextSmaller.index - mid) * (mid - previousSmaller.index - mid) * nums[mid]; 
    // Callout: it should loop 0 to n where i == n need to calculate all remaining numbers in stack. 
    public int maxSumMinProduct(int[] nums) {
        int len = nums.length;
        int M = 1_000_000_007;
        Deque<Integer> stack = new ArrayDeque<>();
        long res = 0;
        long[] preSum = new long[len + 1];
        for (int i = 1; i <= len; i ++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i <= len; i ++) {
            while (!stack.isEmpty() && (i == len || nums[stack.getLast()] >= nums[i])) {
                int mid = stack.removeLast();
                int prevMin = stack.isEmpty() ?  -1 : stack.getLast();
                int nextMin = i;
                long sum = preSum[nextMin] - preSum[prevMin + 1];
                res = Math.max(res, sum * nums[mid]);
            }
            stack.addLast(i);
        }
        return (int)(res % 1_000_000_007);
    }
}