//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
// 
//
// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 👍 292 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String rsString = "";
        // 如果返回字符串长度大于字典中的item，继续循环
        // 返回字符串长度等于字典中item，判断字典值是否小于当前返回值
        for (String itemDic : dictionary) {
            int len1 = rsString.length();
            int len2 = itemDic.length();
            if (len1 > len2 || (len1 == len2 && rsString.compareTo(itemDic) < 0)) {
                continue;
            }
            if(isSubStr(s, itemDic)) {
                rsString = itemDic;
            }
        }
        return rsString;
    }

    /**
     * 判断 longString 是否为 shortString 的子序列
     * @param longString
     * @param shortString
     * @return true是子序列
     *
     * */
    private boolean isSubStr(String longString, String shortString) {
        int i = 0, j = 0;
        while (i < longString.length() && j < shortString.length()) {
            if(longString.charAt(i) == shortString.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == shortString.length() ? true : false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
