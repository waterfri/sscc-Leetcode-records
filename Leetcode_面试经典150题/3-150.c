// #3 无重复字符的最长子串
// 滑动窗口：双指针
// 算法思想：每次扩大窗口时判断当前窗口中是否有重复元素
// 该算法时间复杂度 O(n^2)，用哈希表的话可以 O(n)
int lengthOfLongestSubstring(char* s) {
    // 滑动窗口
    int l = 0;
    int r = 0;
    int len = strlen(s);
    int maxlen = 0;
    // 从头开始滑动，如果 r指针当前元素与 l指针相同，则滑动 l指针到不重复元素位置
    for(; r < len; r++){
        // 遍历当前字串，判断子串中是否有重复元素
        for(int k = l; k < r; k++){
            if(s[k] == s[r]){
                l = k + 1; // 形成新的子串
                break;
            }
        }
        int len = r - l + 1;
        // 更新最大子串长度
        if(len > maxlen){
            maxlen = len;
        }
    }
    return maxlen;
}