class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.length()!=t.length())
        return false;
        //frequency array
        int freq[26]={0};
        //increase count for first
        for(char c:s){
            freq[c-'a']++;
        }
        //dec count
        for(char c:t){
            freq[c-'a']--;
            if (freq[c-'a']<0)
            return false;

        }
        return true;
        
    }
};