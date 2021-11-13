package string;
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// ? 643 ? 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_438 {
    private  Map<Character, Integer> map;
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }
    public static  List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < p.length(); i++) {
            char chr = s.charAt(i);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }
        int start = 0, end = 0;
        while (start < s.length() && end < s.length()) {
            if (end - start < p.length()) {
                end++;
            } else {
                start++;// 窗口内字符串长度等于字符串p的长度,则缩小左侧边界
            }
            if (end - start == p.length() && isAnagrams(s.substring(start, end), map)) {
                resultList.add(start);
            }
        }
        return resultList;
    }
    private static  boolean isAnagrams(String window, Map<Character, Integer> pmap) {
        Map<Character, Integer> winMap = new HashMap<Character, Integer>();
        for(int j = 0; j < window.length(); j++) {
            char chr = window.charAt(j);
            winMap.put(chr, winMap.getOrDefault(chr, 0) + 1);
        }
        for(char chrO : pmap.keySet()){
            if(winMap.get(chrO) != pmap.get(chrO)){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
