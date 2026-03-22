class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> res;
        if(s.size() < p.size()) return res;

        vector<int> pCount(26, 0), sCount(26, 0);

        for(char c : p)
            pCount[c - 'a']++;

        int k = p.size();

        for(int i = 0; i < s.size(); i++) {
            sCount[s[i] - 'a']++;

            // remove left char when window exceeds
            if(i >= k)
                sCount[s[i - k] - 'a']--;

            if(sCount == pCount)
                res.push_back(i - k + 1);
        }

        return res;
    }
};