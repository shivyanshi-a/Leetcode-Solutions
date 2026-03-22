class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.empty()) return "";

        string first = strs[0];

        for (int len = first.length(); len > 0; len--) {
            string prefix = first.substr(0, len);
            bool found = true;

            for (int i = 1; i < strs.size(); i++) {
                if (strs[i].find(prefix) != 0) {
                    found = false;
                    break;
                }
            }

            if (found) return prefix;
        }

        return "";
    }
};
