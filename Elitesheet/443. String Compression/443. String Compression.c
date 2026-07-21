class Solution {
public:
    int compress(vector<char> &chars) {
        const size_t n = chars.size();
        size_t curr_idx = 0;
        for (size_t i = 1, count = 1; i <= n; ++i, ++count)
            if (i == n || chars[i] != chars[i - 1]) {
                chars[curr_idx++] = chars[i - 1];
                if (count != 1) {
                    size_t count_idx = curr_idx;
                    for (; count != 0; count /= 10)
                        chars[curr_idx++] = '0' + count % 10;
                    reverse(&chars[count_idx], &chars[curr_idx]);
                }
                count = 0;
            }
        return curr_idx;
    }
};