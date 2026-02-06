// #14 最长公共前缀
//
//
// 思路：
// 以第一个字符串为基准，纵向遍历每个字符串
// 如果出现某个字符串结束，或者当前字符串当前位置与基准字符串的同一位置字符不相同，则结束并返回最长字串

class Solution{
    public String longestCommonPrefix(String[] strs){

        if(strs == null || strs.length == 0){
            return "";
        }

        String result = strs[0];

        for(int i = 0; i < strs[0].length(); i++){

            char c = result.charAt(i);

            for(int j = 1; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != c){
                    return result.substring(0, i);
                }
            }
        }

        return result;
    }
}

