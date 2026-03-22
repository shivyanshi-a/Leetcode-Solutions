class Solution {
public:
    int longestPalindrome(string s) {
        // Array to store frequency of each ASCII character (128 possible values)
        int charFrequency[128] = {0};
      
        // Count the frequency of each character in the string
        for (char c : s) {
            ++charFrequency[c];
        }
      
        // Calculate the length of the longest palindrome
        int palindromeLength = 0;
      
        // For each character, we can use pairs (even count) in the palindrome
        // If a character appears 5 times, we can use 4 of them (2 pairs)
        for (int frequency : charFrequency) {
            palindromeLength += (frequency / 2) * 2;
        }
      
        // If we haven't used all characters, we can add one more character in the middle
        // This happens when there's at least one character with odd frequency
        if (palindromeLength < s.size()) {
            palindromeLength += 1;
        }
      
        return palindromeLength;
    }
};
