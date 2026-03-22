class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char, int> freq;

        // 1. Count frequency
        for (char c : s) {
            freq[c]++;
        }

        // 2. Buckets: index = frequency
        vector<vector<char>> buckets(s.length() + 1);

        for (auto &p : freq) {
            buckets[p.second].push_back(p.first);
        }

        // 3. Build result from high freq to low
        string result = "";
        for (int i = buckets.size() - 1; i > 0; i--) {
            for (char c : buckets[i]) {
                result.append(i, c);   // repeat char i times
            }
        }

        return result;
    }
};
