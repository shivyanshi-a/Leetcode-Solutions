class Solution {
public:
    string simplifyPath(string path) {
        stack<string> st;
        string temp;

        for(int i = 0; i <= path.size(); i++) {
            if(i == path.size() || path[i] == '/') {
                if(temp == "..") {
                    if(!st.empty()) st.pop();
                }
                else if(!temp.empty() && temp != ".") {
                    st.push(temp);
                }
                temp.clear();
            }
            else {
                temp += path[i];
            }
        }

        string result = "";
        while(!st.empty()) {
            result = "/" + st.top() + result;
            st.pop();
        }

        return result.empty() ? "/" : result;
    }
};