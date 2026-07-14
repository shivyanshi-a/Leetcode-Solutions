class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Determine sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int result = 0;

        while (dvd >= dvs) {

            int shift = 0;

            while (dvd >= (dvs << (shift + 1))) {
                shift++;
            }

            result += (1 << shift);
            dvd -= (dvs << shift);
        }

        return negative ? -result : result;
    }
}