class Solution {
public:
    int myAtoi(string s) {
        int i = 0, n = s.size();
        
        // 1. skip spaces
        while(i < n && s[i] == ' ')
            i++;

        // 2. sign
        int sign = 1;
        if(i < n && (s[i] == '+' || s[i] == '-')) {
            sign = (s[i] == '-') ? -1 : 1;
            i++;
        }

        // 3. convert
        long result = 0;
        while(i < n && isdigit(s[i])) {
            result = result * 10 + (s[i] - '0');

            // 4. overflow check
            if(sign * result > INT_MAX)
                return INT_MAX;
            if(sign * result < INT_MIN)
                return INT_MIN;

            i++;
        }

        return sign * result;
    }
};