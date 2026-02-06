// #344 反转字符串
// 双指针
// 思路：双指针各自向中间移动

class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;

        while(l < r){
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
        return;
    }
}