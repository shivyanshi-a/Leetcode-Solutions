class Solution {
public:
    string reverseWords(string s) {
        int i = s.size() - 1;
        string result = "";
        
        while (i >= 0) {
            while (i >= 0 && s[i] == ' ') i--;   // skip spaces
            if (i < 0) break;
            
            int j = i;
            while (j >= 0 && s[j] != ' ') j--;   // find word start
            
            if (!result.empty()) result += " ";
            result += s.substr(j + 1, i - j);
            
            i = j - 1;
        }
        
        return result;
    }
};